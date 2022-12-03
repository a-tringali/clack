// Andrew Tringali
// Modified 12/3/22

package main;

public class ClientServerSideListener implements Runnable {
    private ClackClient client;

    /**
     * Constructor, sets ClackClient instance to the value of client
     */
    public ClientServerSideListener(ClackClient client) {
        this.client = client;
    }

    /**
     * Overridden: Receives and prints data while connection is open
     */
    @Override
    public void run() {
        while (!client.getCloseConnection()) {
            client.receiveData();
            client.printData();
        }
    }
}
