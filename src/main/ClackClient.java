// Client
package main;

import data.FileClackData;
import data.MessageClackData;

import java.text.FieldPosition;
import java.util.Objects;
import java.util.Scanner;

public class ClackClient {
    static final int DEFAULT_PORT = 7000;
    static final String ENCRYPTION_KEY = "Test_Key";
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private data.ClackData dataToSendToServer;
    private data.ClackData dataToReceiveFromServer;

    private Scanner inFromStd = new Scanner(System.in);

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
    }

    /**
     * Constructor for a given name and host, uses DEFAULT_PORT
     */
    public ClackClient(String userName, String hostName){
        this(userName, hostName, DEFAULT_PORT);
    }

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
    public void start(){

        closeConnection = false;
        while (!closeConnection) {
            readClientData();
            dataToReceiveFromServer = dataToSendToServer;
            printData();
        }
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
            dataToSendToServer = new FileClackData(userName, split[1], 3);
            java.io.File f = new java.io.File(split[1]);
            if (!f.canRead()) {
                System.err.println("Couldn't open File\n");
                dataToSendToServer = null;
            }

        }
        else if (input.equals("LISTUSERS")) {} //Do nothing - DO NOT CALL
        else {
            dataToSendToServer = new MessageClackData(userName, input, 2);
        }
    dataToReceiveFromServer = dataToSendToServer;
    }

    /**
     * Undefined for now
     */
    public void sendData(){}

    /**
     * Undefined for now
     */
    public void receiveData(){}

    /**
     * Undefined for now
     */
    public void printData(){
        if (dataToReceiveFromServer != null) {System.out.println(dataToReceiveFromServer.toString());}
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
}
