package test;
import data.*;

public class TestClackData {
    public static void main(String[] args) {
        //
        // test FileClackData
        //
        FileClackData fileTestOne = new FileClackData("andy", "filename", ClackData.CONSTANT_SENDFILE);
        FileClackData fileTestTwo = new FileClackData();

        // BEGIN SUPERCLASS TESTING
        // test getType()
        System.out.println(fileTestOne.getType());

        // test getUserName()
        System.out.println(fileTestOne.getUserName());

        // test getDate()
        System.out.println(fileTestOne.getDate());
        // END SUPERCLASS TESTING

        // set and get filename
        fileTestOne.setFileName("TestFileOne");
        System.out.println("Name of file: " + fileTestOne.getFileName());

        // test getData
        System.out.println("File contents: " + fileTestOne.getData());

        // test read/writefileContents (empty functions)
        fileTestOne.readFileContents();
        fileTestOne.writeFileContents();

        // test hashCode()
        System.out.println("hashCode: " + fileTestOne.hashCode());

        // test equals()
        if (fileTestOne.equals(fileTestOne)) {
            System.out.println("equals() test passed");
        } else {
            System.exit(1); // this should not happen
        }

        // test toString()
        System.out.println(fileTestOne.toString());

        //
        // test MessageClackData
        //
        MessageClackData messageTestOne = new MessageClackData("andy", "this is a message", ClackData.CONSTANT_SENDMESSAGE);
        MessageClackData messageTestTwo = new MessageClackData();

        // BEGIN SUPERCLASS TESTING
        // test getType()
        System.out.println(messageTestOne.getType());

        // test getUserName()
        System.out.println(messageTestOne.getUserName());

        // test getDate()
        System.out.println(messageTestOne.getDate());
        // END SUPERCLASS TESTING

        // test getData
        System.out.println(messageTestOne.getData());

        // test hashCode()
        System.out.println("hashCode: " + messageTestOne.hashCode());

        // test equals()
        if (!messageTestOne.equals(messageTestTwo)) {
            System.out.println("equals() test passed: objects don't equal");
        } else {
            System.exit(1); // this should not happen
        }

        // test toString()
        System.out.println(messageTestOne.toString());
    }
}