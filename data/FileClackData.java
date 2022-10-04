// File Data

public class FileClackData extends ClackData {
    
    private String fileName;
    private String fileContents;

    public FileClackData(String cUsername, String cFileName, int type){

    }

    public FileClackData(){

    }

    public void setFileName(String sFileName){
        this.fileName = sFileName;
    }

    public String getFileName(){
        return fileName;

    }

    public String getData(){
        return "change this - file";
    }

    public void readFileContents(){

    }

    public void writeFileContents(){

    }

    public int hashCode() {
        return 0; // rewrite
    }

    public boolean equals(){
        return true; // rewrite
    }

    public String toString(){
        return "test"; // return full description of class with all instance variables (including super class)
    }
}
