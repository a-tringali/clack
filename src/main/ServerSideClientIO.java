package main;

import data.ClackData;
import data.MessageClackData;

import java.io.*;
import java.net.*;

public class ServerSideClientIO implements Runnable {
    // constants
    private static final boolean DEFAULT_CLOSE_CONNECTION = false;
    private static final ClackData DEFAULT_DATA_TO_RECEIVE_FROM_CLIENT = null;
    private static final ClackData DEFAULT_DATA_TO_SEND_TO_CLIENT = null;
    private static final ObjectInputStream DEFAULT_IN_FROM_CLIENT = null;
    private static final ObjectOutputStream DEFAULT_OUT_TO_CLIENT = null;
    private static final String SERVER_NAME = "server";
    private static final String DEFAULT_USERNAME = "Anonymous";

    // instance variables
    private String userName;
    private boolean closeConnection;
    private ClackData dataToReceiveFromClient;
    private ClackData dataToSendToClient;


    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;

    private ClackServer server;
    private Socket clientSocket;

    private MessageClackData userData = new MessageClackData(userName, "", 0);

    /**
     * Constructor for a given server and client
     *
     * @param server a set ClackServer
     * @param clientSocket a set Socket
     */
    ServerSideClientIO( ClackServer server, Socket clientSocket ) {
        this.server = server;
        this.clientSocket = clientSocket;
        this.closeConnection = DEFAULT_CLOSE_CONNECTION;
        this.dataToReceiveFromClient = DEFAULT_DATA_TO_RECEIVE_FROM_CLIENT;
        this.dataToSendToClient = DEFAULT_DATA_TO_SEND_TO_CLIENT;
        this.inFromClient = DEFAULT_IN_FROM_CLIENT;
        this.outToClient = DEFAULT_OUT_TO_CLIENT;
        this.userName = DEFAULT_USERNAME;
    }

    /**
     * allows for multithreading
     */
    @Override
    public void run() {
        try {
            this.inFromClient = new ObjectInputStream(this.clientSocket.getInputStream());
            this.outToClient = new ObjectOutputStream(this.clientSocket.getOutputStream());

            while (!closeConnection) {
                receiveData();
                this.server.broadcast(dataToReceiveFromClient);
            }

            inFromClient.close();
            outToClient.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    /**
     * Sends data from the server
     */
    public void sendData() {
        try {
            if (!closeConnection) {
                outToClient.writeObject(dataToSendToClient);
            }
        } catch(IOException ioe) {
            System.err.println("IOException with writing an object to the client: ");
        }
    }


    /**
     * Sets the data to be sent as directed
     *
     * @param dataToSendToClient ClackData to be set
     */
    public void setDataToSendToClient(ClackData dataToSendToClient) {
        this.dataToSendToClient = dataToSendToClient;
    }


    /**
     * Receives data
     */
    public void receiveData() {
        try {
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();
            if (dataToReceiveFromClient == null) {
                server.remove(this);
                closeConnection = true;
            }

            updateUserName();


        } catch(ClassNotFoundException cnfe) {
            System.err.println("Class Not Found Exception with reading an object from the Client: " + cnfe.getMessage());
        } catch(IOException ioe) {
            System.err.println("IOException with reading an object from the Client: " + ioe.getMessage());
        }
    }

    /**
     * Updates userName based on most recent message.
     */
    public void updateUserName () {
        if (dataToReceiveFromClient != null) {
            this.userName = dataToReceiveFromClient.getUserName();
        }
    }

    public String getUserName(){
        return userName;
    }

}