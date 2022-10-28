package test;

import main.ClackClient;

public class testClient {
    static private ClackClient clientOne = new ClackClient();
    static private ClackClient clientTwo = new ClackClient("Anonymous", "localhost", 7000);
    static private ClackClient clientThree = new ClackClient("John");


    /**
     * Returns true if the function equals() works correctly
     */
    public boolean testEquals(){
        return (clientOne.equals(clientTwo) != clientOne.equals(clientThree));
    }

    /**
     * returns String of clientOne
     */
    public String testString(){return clientOne.toString();}

    /**
     * tests all associated "get" functions
     */
    public boolean testGets(){return ((clientOne.getHostName().equals("localhost")) && (clientOne.getUserName().equals("Anonymous")) && (clientOne.getPort() == 7000));}

    /**
     * checks hash output is consistent with equals
     */
    public boolean testHash(){return (clientOne.hashCode() == clientTwo.hashCode()) != (clientOne.hashCode() == clientThree.hashCode());}

    public void testRun(){clientOne.start();}

    /**
     * Allows the user to run an instance of the client and perform debugging and testing
     */


}
