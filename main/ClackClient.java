// Client
package main;

import package.data;

public class ClackClient {
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private clackData dataToSendToServer;
    private clackData dataToReceiveFromServer;

    public ClackClient(String userName, String hostName, int port){
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
    }

    public ClackClient(String userName, String hostName){
        this(userName, hostName, 7000);
    }

    public ClackClient(String userName){
        this(username, "localhost");
    }

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
    @override
    public boolean equals(Object o){
        if (this.hostName == o.getHostName() && this.userName == o.getUserName() && this.port == o.getPort()) {return true;}
        else {return false;}
    }
    @override
    public int hashCode(){return this.port + this.userName.hashCode() + this.hostName.hashCode()}
    @override
    public String toString({return "Username: " + this.userName + "\nHostname: " + this.hostName + "\nPort: " + this.port}

}
