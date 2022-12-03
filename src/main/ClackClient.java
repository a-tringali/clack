// Client
package main;

import data.ClackData;
import data.FileClackData;
import data.MessageClackData;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.Scanner;

public class ClackClient {
    /**
     * Primary use of the client, allows for establishing a connection and operating said connection
     * Pretty proud of this
     * @param args
     */
    public static void main ( String[] args ) {
        ClackClient clackClient;
        if ( args.length == 0 ) {
            clackClient = new ClackClient();
        } else {
            Scanner sc = new Scanner(args[0]);
            sc.useDelimiter("@");
            String userName = sc.next();
            if (!sc.hasNext()) {
                clackClient = new ClackClient(userName);
            } else {
                sc.useDelimiter("[@:]");
                String hostName = sc.next();
                if (!sc.hasNext()) {
                    clackClient = new ClackClient(userName, hostName);
                } else {
                    int port = sc.nextInt();
                    clackClient = new ClackClient(userName, hostName, port);
                }
            }
            sc.close();
        }
        clackClient.start();
    }

    static final int DEFAULT_PORT = 7000;
    static final String ENCRYPTION_KEY = "Test_Key";
    private final String userName;
    private final String hostName;
    private final int port;
    private boolean closeConnection;
    private ClackData dataToSendToServer;
    private ClackData dataToReceiveFromServer;
    private ObjectInputStream inFromServer;
    private ObjectOutputStream outToServer;
    private Scanner inFromStd;
    private Socket skt;


    /**
     * Constructor for a given name, host and port
     */
    public ClackClient(String userName, String hostName, int port){
        if (userName == null || hostName == null || port <1024) {throw new IllegalArgumentException("Invalid Client Parameters");}

        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
        this.inFromServer = null;
        this.outToServer = null;
    }

    /**
     * Constructor for a given name and host, uses DEFAULT_PORT
     */
    public ClackClient(String userName, String hostName){this(userName, hostName, DEFAULT_PORT);}

    /**
     * Constructor for a given user, uses DEFAULT_PORT and localhost
     */
    public ClackClient(String userName){this(userName, "localhost");}

    /**
     * Constructor for an anonymous user, uses localhost and DEFAULT_PORT
     */
    public ClackClient(){
        this("Anonymous");
    }

    /**
     * Undefined for now
     */

    public void readClientData(){
        System.out.println("Enter your command/message\n");
        String input = inFromStd.nextLine();
        String[] split = input.split(" ", 3);
        if (split[0].equals("DONE")) {closeConnection = true;}
        else if (split[0].equals("SENDFILE")) {
            FileClackData tempData = new FileClackData(userName, split[1], 3);
            try {tempData.readFileContents(ENCRYPTION_KEY);}
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if(input.equals("LISTUSERS")) {} //Do nothing - DO NOT CALL
        else {dataToSendToServer = new MessageClackData(userName, input, 2);}
    }

    /**
     * Sends data to server
     */
    public void sendData(ClackData data) {
        try {
            outToServer.writeObject(data);
        } catch ( InvalidClassException ice ) {
            System.err.println("InvalidClassException");
        } catch ( NotSerializableException nse) {
            System.err.println("NotSerializableException");
        } catch ( IOException ioe ) {
            System.err.println ("IOException in sendData");
        }
    }
    /**
     * Pulls data from server
     */
    public ClackData receiveData() {
        try {
            dataToReceiveFromServer = (ClackData) inFromServer.readObject();
        } catch ( ClassCastException cce ) {
            System.err.println("ClassCastException");
        } catch ( ClassNotFoundException cnf ) {
            System.err.println("ClassNotFoundException");
        } catch ( IOException ioe ) {
            System.err.println("IOException in receiveData");
        }
        return dataToReceiveFromServer;
    }

    /**
     * Intakes data from server
     */
    public void printData(){
        if (dataToReceiveFromServer != null) {System.out.println(dataToReceiveFromServer);}
        else {System.err.println("No data to retrieve\n");}
    }

    /**
     * Returns username
     */
    public String getUserName(){return this.userName;}

    /**
     * Returns hostname
     */
    public String getHostName(){return this.hostName;}

    /**
     * Returns port
     */
    public int getPort(){return this.port;}

    /**
     * Overrides equals for valid comparisons
     */
    @Override
    public boolean equals(Object other){ // Once again correcting to be optimal
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClackClient)) {
            return false;
        }

        // Casts other to be a ClackClient to access its instance variables.
        ClackClient otherClackClient = (ClackClient) other;


        return this.userName.equals(otherClackClient.userName) &&
                this.hostName.equals(otherClackClient.hostName) &&
                this.port == otherClackClient.port &&
                this.closeConnection == otherClackClient.closeConnection &&
                Objects.equals(this.dataToSendToServer, otherClackClient.dataToSendToServer) &&
                Objects.equals(this.dataToReceiveFromServer, otherClackClient.dataToReceiveFromServer);
    }

    /**
     * Overrides hashcode for consistency with equals
     */
    @Override
    public int hashCode(){int result = 23;

        // Correcting for optimal performance
        result = 31 * result + Objects.hashCode(this.userName);
        result = 31 * result + Objects.hashCode(this.hostName);
        result = 31 * result + this.port;
        result = 31 * result + Objects.hashCode(this.closeConnection);
        result = 31 * result + Objects.hashCode(this.dataToSendToServer);
        result = 31 * result + Objects.hashCode(this.dataToReceiveFromServer);

        return result;}

    /**
     * Returns all values in string form
     */
    @Override
    public String toString(){ //Correcting for optimal performance
        return "This instance of ClackClient has the following properties:\n"
                + "Username: " + this.userName + "\n"
                + "Host name: " + this.hostName + "\n"
                + "Port number: " + this.port + "\n"
                + "Connection status: " + (this.closeConnection ? "Closed" : "Open") + "\n"
                + "Data to send to the server: " + this.dataToSendToServer + "\n"
                + "Data to receive from the server: " + this.dataToReceiveFromServer + "\n";
    }

    /**
     * Start the program - initializes sockets and loops through data IO
     */
    public void start() {
        // #1 of Part 4 implemented & fixed -Andrew
        try {
            inFromStd = new Scanner(System.in);
            skt = new Socket(this.hostName, this.port);
            this.outToServer = new ObjectOutputStream( skt.getOutputStream() );
            this.inFromServer = new ObjectInputStream( skt.getInputStream() );
            ClientServerSideListener clientServerSideListener = new ClientServerSideListener(this);
            Thread thread = new Thread(clientServerSideListener);
            thread.start();
            while(!closeConnection){
                readClientData();
                sendData(dataToSendToServer);
            }
        } catch ( UnknownHostException uhe ) {
            System.err.println(uhe.getMessage());
            System.err.println("UnknownHostException");
        } catch ( IOException ioe ) {
            System.err.println(ioe.getMessage());
            System.err.println("IOException");
        } catch ( IllegalArgumentException iae ) {
            System.err.println(iae.getMessage());
            System.err.println("IllegalArgumentException");
        }

    }

    public boolean getCloseConnection() {
        return closeConnection;
    }
}
