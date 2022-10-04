// Server
package main;
public class ClackServer {

    static final int DEFAULT_PORT = 7000;
    final private int port;
    private boolean closeConnection;
    private data.ClackData dataToReceiveFromClient;
    private data.ClackData dataToSendToClient;

    /**
     * Constructor for a given port
     */
    public ClackServer(int port){
        this.port = port;
        this.dataToReceiveFromClient = null;
        this.dataToSendToClient = null;
    }

    /**
     * Default constructor, calls DEFAULT_PORT
     */
    public ClackServer(){this(DEFAULT_PORT);}

    /**
     * Undefined as of now
     */
    public void start(){}

    /**
     * Undefined as of now
     */
    public void sendData(){}

    /**
     * Undefined as of now
     */
    public void receiveData(){}

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
}
