// File Data for Clack
// Andrew Tringali 10/28/22

package data;
import java.io.*;

public class FileClackData extends data.ClackData {
    
    private String fileName;
    private String fileContents;

    /**
     * Passes given username and action type to superconstructor
     * Also create FileClackData subobject with filename "cFileName" and
     * fileContents set to an empty string (test will fail if null)
     */

    public FileClackData(String cUsername, String cFileName, int type){
        super(cUsername, type);
        this.fileName = cFileName;
        this.fileContents = "";
    }

    public FileClackData(){
        super();
    }

    /**
     * Sets the name of the file to specified value sFileName
     */
    public void setFileName(String sFileName){
        this.fileName = sFileName;
    }

    /**
     * Returns fileName
     */
    public String getFileName(){
        return fileName;
    }

    /** 
     * Returns fileContents
     */
    public String getData(){
        return fileContents;
    }

    /**
     * Overloaded: Decrypts and returns fileContents
     */
    public String getData(String key){
        return super.decrypt(fileContents, key);
    }

    /**
     * Reads contents of file fileName to fileContents
     */
    public void readFileContents() throws IOException {
        File filedata = new File(fileName);
        FileReader read = new FileReader(filedata);
        int i;
        String readData = "";

        try {
            while ((i = read.read()) != -1) {
                readData = readData + (char) i;
            }
            fileContents = readData;
        } catch (FileNotFoundException missingFile) {
            System.err.println("Warning: File missing");
            throw new FileNotFoundException("Unable to find target file");
        } catch (IOException errorIO) {
            System.err.println("Warning: Error reading data from file");
            throw new IOException("Unable to read data from file");
        } finally {
            read.close();
        }
    }

    /**
     * Overloaded: Uses key to decrypt contents before reading
     */

    public void readFileContents(String key) throws IOException {
        File filedata = new File(fileName);
        FileReader read = new FileReader(filedata);
        int i;
        String readData = "";

        try {
            while ((i = read.read()) != -1) {
                readData = readData + (char) i;
            }
            // Set fileContents to decrypted string
            fileContents = super.decrypt(readData, key);
        } catch (FileNotFoundException missingFile) {
            System.err.println("Warning: File missing");
            throw new FileNotFoundException("Unable to find target file" + fileName);
        } catch (IOException errorIO) {
            System.err.println("Warning: Error reading data from file");
            throw new IOException("Unable to read data from file" );
        } finally {
            read.close();
        }
    }
    /**
     * Writes contents of fileContents to file fileName
     */
    public void writeFileContents() throws IOException {
        File filedata = new File(fileName);
        FileWriter write = new FileWriter(filedata);

        try {
            write.write(fileContents);
        } catch (IOException errorIO) {
            System.err.println("Warning: Error writing data to file" + fileName);
            throw new IOException("Unable to write data to file" + fileName);
        } finally {
            write.close();
        }
    }

    /**
     * Overloaded: Uses key to encrypt contents before writing
     */
    public void writeFileContents(String key) throws IOException {
        File filedata = new File(fileName);
        FileWriter write = new FileWriter(filedata);

        try {
            String encryptedFileContents = super.encrypt(fileContents, key);
            write.write(encryptedFileContents);
        } catch (IOException errorIO) {
            System.err.println("Warning: Error writing data to file " + fileName);
            throw new IOException("Unable to write data to file" + fileName);
        } finally {
            write.close();
        }
    }

    /**
     * hashCode() override
     */
    @Override
    public int hashCode(){
        return super.getUserName().hashCode() ^ super.getType() ^ super.getDate().hashCode() ^ fileName.hashCode() ^ fileContents.hashCode();
    }

    /**
     * equals() override
     */
    @Override
    public boolean equals(Object other){
        FileClackData otherData = (FileClackData)other;
        return this.fileName == otherData.fileName && this.fileContents == otherData.fileContents && this.getUserName() == otherData.getUserName() && this.getType() == otherData.getType() && this.getDate() == otherData.getDate(); // revisit this later
    }

    /**
     * toString() override
     * returns a full description of the class with all instance variables (including those in the super class)
     */
    @Override
    public String toString(){
        return "username: " + super.getUserName() 
        + "\ntype: " + super.getType() 
        + "\ndate: " + super.getDate() 
        + "\nfile name: " + fileName
        + "\nfile contents: " + fileContents;
    }
}
