// Data
import java.util.Date;

public abstract class ClackData {
    private String username;
    private int type;
    private Date date;

    // create a user
    public ClackData(String cUsername, int cType){
        this.username = cUsername;
        this.type = cType;
        this.date = new Date();
    }

    // create an anonymous user
    public ClackData(int cType){
        this("anon", cType);
    }

    // default constructor
    public ClackData(){
        this("anon", 123456);
    }

    // return the type
    public int getType(){
        return this.type;
    }

    // return the username
    public String getUserName(){
        return this.username;
    }

    // return the date
    public Date getDate(){
        return this.date; // revisit
    }

    // return data
    abstract void getData();

}
