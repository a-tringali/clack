// Data
import java.util.Date;

public abstract class ClackData {
    
    // members
    private String username;
    private int type;
    private Date date;

    /**
     * Creates a user with name "username," account type "cType"
     * Date is automatically created based on the current time
    */
    public ClackData(String cUsername, int cType){
        this.username = cUsername;
        this.type = cType;
        this.date = new Date();
    }

    /**
     * If an account name isn't specified, create an anonymous account
    */
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
    abstract String getData();

}
