// Data Class for Clack
// Andrew Tringali 10/3/22

// Data
package data;

import java.util.Date;

public abstract class ClackData {
    
    // members
    private String username;
    private int type;
    private Date date;

    public static final int CONSTANT_LISTUSERS = 0;
    public static final int CONSTANT_LOGOUT = 1;
    public static final int CONSTANT_SENDMESSAGE = 2;
    public static final int CONSTANT_SENDFILE = 3; 

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

    /**
     * Default constructor with logout 
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
