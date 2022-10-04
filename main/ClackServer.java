// Server
package main;
public class ClackServer {

    static final int DEFAULT_PORT = 7000;
    final private int port;
    private boolean closeConnection;
    private data.ClackData dataToReceiveFromClient;
    private data.ClackData dataToSendToClient;

    ClackServer(int port){this.port = port; this.dataToReceiveFromClient = null; this.dataToSendToClient = null;}
    ClackServer(){this(DEFAULT_PORT);}

    public void start(){}
    public void sendData(){}
    public void receiveData(){}
    public int getPort(){return this.port;}
    @Override
    public boolean equals(Object o){return this.hashCode() == o.hashCode() && this.getClass() == o.getClass();}
    @Override
    public int hashCode() {return this.port + this.dataToSendToClient.hashCode() + this.dataToReceiveFromClient.hashCode();}

    @Override
    public String toString() {
        return  "Port: " + port +
                "\nConnection Closed: " + closeConnection +
                "\nData To Send: " + dataToSendToClient.toString() +
                "\nData To Receive: " + dataToReceiveFromClient.toString();
    }
}
