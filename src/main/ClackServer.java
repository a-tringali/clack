// Server
// Henry Rausch
// Modified by Andrew Tringali 11/15/22

package main;

import data.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClackServer {

    static final int DEFAULT_PORT = 7000;
    final private int port;
    private boolean closeConnection = false;
    //private ClackData dataToReceiveFromClient;
    private ClackData dataToSendToClient;

    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;

    private ServerSocket servSock;
    private Socket cliSock;
    ArrayList<ServerSideClientIO> serverSideClientIOList = new ArrayList<ServerSideClientIO>();
    ArrayList<String> users = new ArrayList<String>();

    /**
     * Constructor for a given port
     */
    public ClackServer(int port) throws IllegalArgumentException {
        if (port < 1024) {
            throw new IllegalArgumentException("Error: IllegalArgumentException (Is the port number less then 1024?)");
        }
        this.port = port;

        this.dataToSendToClient = null;

    }

    /**
     * Default constructor, calls DEFAULT_PORT
     */
    public ClackServer(){this(DEFAULT_PORT);}

    /**
     * Gets connections from client and echoes client data
     */
    public void start() {
        try {
            ServerSocket sskt = new ServerSocket(getPort());
            System.out.println("Server started on port " + getPort());

            while (!closeConnection) {
                Socket clientSocket = sskt.accept();

                ServerSideClientIO sscio = new ServerSideClientIO(this , clientSocket);
                serverSideClientIOList.add(sscio);
                users.add(sscio.getUserName());
                Thread t = new Thread(sscio);
                t.start();
            }

            sskt.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    /**
     * Broadcasts a ClackData object to all ClackClients connected
     *
     * @param dataToBroadcastToClients  ClackData to be broadcasted
     */
    public synchronized void broadcast(ClackData dataToBroadcastToClients) {
        for (int i = 0; i < serverSideClientIOList.size(); i++) {
            if (dataToBroadcastToClients.getType() == 0) {
                serverSideClientIOList.get(i).setDataToSendToClient(new MessageClackData("USERS REQUEST", users.toString(), 0));
                serverSideClientIOList.get(i).sendData();
            }
            else {
                serverSideClientIOList.get(i).setDataToSendToClient(dataToBroadcastToClients);
                serverSideClientIOList.get(i).sendData();
            }
            System.out.println(users.toString());
        }
    }

    /**
     * Removes ServerSideClientIO object from the list of ServerSideClientIO objects.
     *
     * @param sscio ServerSideClientIO object to be removed
     */
    public synchronized void remove(ServerSideClientIO sscio) {
        serverSideClientIOList.remove(sscio);
    }

    /**
     * Sends data to client without returning anything
     */
    public void sendData() {
        try {
            outToClient.writeObject(dataToSendToClient);
            outToClient.flush();
        } catch (IOException e) {
            System.err.println("Error: IOException when sending data to client");
        }
    }


    /**
     * Receives data from client without returning anything
     */
    /*
    public void receiveData() {
        try {
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();
        } catch (IOException e) {
            System.err.println("Error: IOException when receiving data from client");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: ClassNotFoundException when receiving data from client");
        }
    }
    */
    /**
     * Returns the port value
     */
    public int getPort(){return this.port;}

    /**
     * Overrides equals
     */
    @Override
    public boolean equals(Object o){return this.hashCode() == o.hashCode() && this.getClass() == o.getClass();}

    /**
     * Manipulates the hashcode to be consistent with equals
     */
    @Override
    public int hashCode() {return this.port + this.dataToSendToClient.hashCode();}

    /**
     * Gives a readable string output of all values
     */
    @Override
    public String toString() {
        return  "Port: " + port +
                "\nConnection Closed: " + closeConnection +
                "\nData To Send: " + dataToSendToClient.toString();
    }


    /**
     * Main
     */
    public static void main(String[] args) {
        ClackServer clckServ;
        if (args.length == 1) {
            clckServ = new ClackServer(Integer.parseInt(args[0]));
        } else {
            clckServ = new ClackServer();
        }
        clckServ.start();
    }

    public String getUsers(){
        return users.toString();
    }
}
