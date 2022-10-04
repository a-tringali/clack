// File Data for Clack
// Andrew Tringali 10/3/22

package data;

public class FileClackData extends data.ClackData {
    
    private String fileName;
    private String fileContents;

    public FileClackData(String cUsername, String cFileName, int type){
        super(cUsername, type);
        this.fileName = cFileName;
        this.fileContents = null;
    }

    public FileClackData(){
        super();
    }

    public void setFileName(String sFileName){
        this.fileName = sFileName;
    }

    public String getFileName(){
        return fileName;
    }

    public String getData(){
        return fileContents;
    }

    public void readFileContents(){
        // no code at this time, just declaration
    }

    public void writeFileContents(){
        // no code at this time, just declaration
    }

    public int hashCode() {
        return 0; // rewrite
    }

    public boolean equals(Object other){
        FileClackData otherData = (FileClackData)other;
        return this.fileName == otherData.fileName && this.fileContents == otherData.fileContents && this.getUserName() == otherData.getUserName() && this.getType() == otherData.getType() && this.getDate() == otherData.getDate(); // revisit this later
    }

    public String toString(){
        return "username: " + super.getUserName() 
        + "\ntype: " + super.getType() 
        + "\ndate: " + super.getDate() 
        + "\nfile name: " + fileName
        + "\nfile contents: " + fileContents;
    }
}
