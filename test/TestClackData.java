package test;
import data.*;

public class TestClackData {
    public static void main(String[] args) {
        MessageClackData test1 = new MessageClackData("andy", "this is a message", ClackData.CONSTANT_SENDMESSAGE);
        FileClackData test2 = new FileClackData("andy", "filename or something, lol", ClackData.CONSTANT_SENDFILE);
        System.out.println(test1.toString());
        System.out.println(test2.toString());
    }
}
