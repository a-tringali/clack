// Server
// Henry Rausch
// Modified by Andrew Tringali 11/15/22

package main;
import data.ClackData;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClackServer {

    static final int DEFAULT_PORT = 7000;
    final private int port;
    private boolean closeConnection;
    private ClackData dataToReceiveFromClient;
    private ClackData dataToSendToClient;

    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;

    private ServerSocket servSock;
    private Socket cliSock;

    /**
     * Constructor for a given port
     */
    public ClackServer(int port) throws IllegalArgumentException {
        if (port < 1024) {
            throw new IllegalArgumentException("Error: IllegalArgumentException (Is the port number less then 1024?)");
        }
        this.port = port;
        this.dataToReceiveFromClient = null;
        this.dataToSendToClient = null;
        this.inFromClient = null;
        this.outToClient = null;
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
            servSock = new ServerSocket(port);
            cliSock = servSock.accept();

            inFromClient = new ObjectInputStream(cliSock.getInputStream());
            outToClient = new ObjectOutputStream(cliSock.getOutputStream());

            receiveData();
            dataToSendToClient = dataToReceiveFromClient;
            sendData();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Error: IOException in ClackServer");
        }
        try {
            servSock.close();
            cliSock.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Error: IOException when closing connections");
        }
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
    public void receiveData() {
        try {
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();
        } catch (IOException e) {
            System.err.println("Error: IOException when receiving data from client");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: ClassNotFoundException when receiving data from client");
        }
    }

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
    public int hashCode() {return this.port + this.dataToSendToClient.hashCode() + this.dataToReceiveFromClient.hashCode();}

    /**
     * Gives a readable string output of all values
     */
    @Override
    public String toString() {
        return  "Port: " + port +
                "\nConnection Closed: " + closeConnection +
                "\nData To Send: " + dataToSendToClient.toString() +
                "\nData To Receive: " + dataToReceiveFromClient.toString();
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
}
