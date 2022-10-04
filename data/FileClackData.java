// File Data for Clack
// Andrew Tringali 10/3/22

package data;

public class FileClackData extends data.ClackData {
    
    private String fileName;
    private String fileContents;

    /*
     * Passes given username and action type to superconstructor
     * Also create FileClackData subobject with filename "cFileName" and
     * fileContents set to null
     */

    public FileClackData(String cUsername, String cFileName, int type){
        super(cUsername, type);
        this.fileName = cFileName;
        this.fileContents = null;
    }



    public FileClackData(){
        super();
    }

    /*
     * Sets the name of the file to specified value sFileName
     */
    public void setFileName(String sFileName){
        this.fileName = sFileName;
    }

    /*
     * Returns fileName
     */
    public String getFileName(){
        return fileName;
    }

    /* 
     * Returns fileContents
     */
    public String getData(){
        return fileContents;
    }

    /*
     * This is just a declaration, but it will eventually read from fileContents
     */
    public void readFileContents(){
        // no code at this time, just declaration
    }

    /*
     * This is just a declaration, but it will eventually write to fileContents
     */
    public void writeFileContents(){
        // no code at this time, just declaration
    }

    /*
     * hashCode() override
     */
    public int hashCode() {
        return 0; // rewrite
    }

    /*
     * equals() override
     */
    public boolean equals(Object other){
        FileClackData otherData = (FileClackData)other;
        return this.fileName == otherData.fileName && this.fileContents == otherData.fileContents && this.getUserName() == otherData.getUserName() && this.getType() == otherData.getType() && this.getDate() == otherData.getDate(); // revisit this later
    }

    /*
     * toString() override
     * returns a full description of the class with all instance variables (including those in the super class)
     */
    public String toString(){
        return "username: " + super.getUserName() 
        + "\ntype: " + super.getType() 
        + "\ndate: " + super.getDate() 
        + "\nfile name: " + fileName
        + "\nfile contents: " + fileContents;
    }
}
