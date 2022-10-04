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

    public ClackClient(String userName, String hostName, int port){
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
    }

    public ClackClient(String userName, String hostName){
        this(userName, hostName, DEFAULT_PORT);
    }

    public ClackClient(String userName){this(userName, "localhost");}

    public ClackClient(){
        this("Anonymous");
    }

    public void start(){}
    public void readClientData(){}
    public void sendData(){}
    public void receiveData(){}
    public void printData(){}
    public String getUserName(){return this.userName;}
    public String getHostName(){return this.hostName;}
    public int getPort(){return this.port;}
    @Override
    public boolean equals(Object o){
        if (this.hashCode() == o.hashCode() && this.getClass() == o.getClass()) {return true;}
        else {return false;}
    }
    @Override
    public int hashCode(){return this.port + this.userName.hashCode() + this.hostName.hashCode() + this.dataToReceiveFromServer.hashCode() + this.dataToSendToServer.hashCode();}
    @Override
    public String toString(){
        return "Username: " + this.userName +
                "\nHostname: " + this.hostName +
                "\nPort: " + this.port +
                "\nData To Receive: " + dataToSendToServer.toString() +
                "\nData To Send: " + dataToReceiveFromServer.toString();
    }

}
