// Client
package main;

public class ClackClient {
    static final int DEFAULT_PORT = 7000;
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private data.ClackData dataToSendToServer;
    private data.ClackData dataToReceiveFromServer;

    /**
     * Constructor for a given name, host and port
     */
    public ClackClient(String userName, String hostName, int port){
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
    public void start(){}

    /**
     * Undefined for now
     */
    public void readClientData(){}

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
    public void printData(){};

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
    public boolean equals(Object o){
        if (this.hashCode() == o.hashCode() && this.getClass() == o.getClass()) {return true;}
        else {return false;}
    }

    /**
     * Overrides hashcode for consistency with equals
     */
    @Override
    public int hashCode(){return this.port + this.userName.hashCode() + this.hostName.hashCode() + this.dataToReceiveFromServer.hashCode() + this.dataToSendToServer.hashCode();}

    /**
     * Returns all values in string form
     */
    @Override
    public String toString(){
        return "Username: " + this.userName +
                "\nHostname: " + this.hostName +
                "\nPort: " + this.port +
                "\nData To Receive: " + dataToSendToServer.toString() +
                "\nData To Send: " + dataToReceiveFromServer.toString();
    }

}
