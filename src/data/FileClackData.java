// File Data for Clack
// Andrew Tringali 10/28/22

package data;

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
     * This is just a declaration, but it will eventually read from fileContents
     */
    public void readFileContents(){
        // open file "filename"

        // read contents to fileContents

        // close file
    }

    /**
     * Overloaded: Uses key to decrypt contents before reading
     */

    public void readFileContents(String dKey){
        // lol watch this
    }

    /**
     * This is just a declaration, but it will eventually write to fileContents
     */
    public void writeFileContents(){
        // no code at this time, just declaration
    }

    /**
     * Overloaded: Uses key to encrypt contents before writing
     */
    public void writeFileContents(String eKey){
        // no code at this time, just declaration
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
