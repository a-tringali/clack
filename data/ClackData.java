// Data Class for Clack
// Andrew Tringali 10/3/22

package data;
import java.util.Date;

public abstract class ClackData {
    
    // members
    private String username;
    private int type;
    private Date date;

    // type variable constants
    public static final int CONSTANT_LISTUSERS = 0;
    public static final int CONSTANT_LOGOUT = 1;
    public static final int CONSTANT_SENDMESSAGE = 2;
    public static final int CONSTANT_SENDFILE = 3; 

    /**
     * Creates ClackData object with name "username," action type "cType"
     * Date is automatically selected based on the current time
     */
    public ClackData(String cUsername, int cType){
        this.username = cUsername;
        this.type = cType;
        this.date = new Date();
    }

    /**
     * If a name isn't specified, use "anon" for an anonymous user
     */
    public ClackData(int cType){
        this("anon", cType);
    }

    /**
     * Default constructor
     */
    public ClackData(){
        this("anon", CONSTANT_LOGOUT);
    }

    /**
     * Returns the type
     */
    public int getType(){
        return this.type;
    }

    /**
     * Returns the username
     */
    public String getUserName(){
        return this.username;
    }

    /**
     * Returns the date
     */
    public Date getDate(){
        return this.date; // returns a reference, not a copy
    }

    /**
     * Placeholder data function- overridden in MessageClackData/FileClackData
     */
    abstract String getData();
}
