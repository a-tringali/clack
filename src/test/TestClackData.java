package test;
import java.io.IOException;

import data.*;

// i call this one the spaghetti code special
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
         fileTestOne.setFileName("test.txt");
         System.out.println("Name of file: " + fileTestOne.getFileName());

         // test readFileContents()
         try {
            fileTestOne.readFileContents();
         } catch (IOException exc) {
            System.out.println("Exception when testing readFileContents");
         }
        
        // test getData
        System.out.println("File contents: " + fileTestOne.getData());

         // test writeFileContents()
         try {
            fileTestOne.writeFileContents();
         } catch (IOException exc) {
            System.out.println("Exception when testing writeFileContents");
         }
        

         // verify encryption works
        if (fileTestOne.verifyEncrypt() == true) {
            System.out.println("Encryption test passed");
        } else {
            System.out.println("Encryption test failed");
        }

        // test writeFileContents() with encryption
        fileTestOne.setFileName("test_encrypted.txt");
        try {
            fileTestOne.writeFileContents("139kx");
         } catch (IOException exc) {
            System.out.println("Exception when testing writeFileContents");
         }

        System.out.println("File contents (encrypted, NOT readable!): \n" + fileTestOne.getData());

        // test readFileContents() with decryption
        try {
            fileTestOne.readFileContents("139kx");
         } catch (IOException exc) {
            System.out.println("Exception when testing readFileContents");
        }

        System.out.println("File contents (decrypted): \n" + fileTestOne.getData());


/**

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
    */
    }
}
