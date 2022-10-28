// Message Data for Clack
// Andrew Tringali 10/28/22

package data;

public class MessageClackData extends ClackData {
    
    //  members
    private String message;

    /**
     * Passes given name and action type to superconstructor
     * Also creates MessageClackData subobject with message set to "cMessage" string
     */
    public MessageClackData(String cUsername, String cMessage, int cType){
        super(cUsername, cType);
        this.message = cMessage;
    }

    /**
     * Encrypted constructor: Same as unencrypted, but also takes String value "cKey" as a parameter
     * Creates MessageClackData subobject with "cMessage" string run through encrypt() method
     */
    public MessageClackData(String cUsername, String cMessage, String cKey, int cType) {
        super(cUsername, cType);
        this.message = super.encrypt(cMessage, cKey);
    }

    /**
     * Default constructor; just calls superconstructor with no arguments
     */
    public MessageClackData(){
        super();
    }

    // methods

    /**
     * Returns the contents of message
     */
    public String getData(){
        return message;
    }

    /**
     * Overloaded: Decrypts and returns message
     */
    public String getData(String key){
        return super.decrypt(message, key);
    }

    /**
     * hashcode() override
     */
    @Override
    public int hashCode(){
        return super.getUserName().hashCode() ^ super.getType() ^ super.getDate().hashCode() ^ message.hashCode();
    }
    
    /**
     * equals() override
     */
    @Override
    public boolean equals(Object other){
        MessageClackData otherData = (MessageClackData)other;
        return this.message == otherData.message && this.getUserName() == otherData.getUserName() && this.getType() == otherData.getType() && this.getDate() == otherData.getDate(); // revisit this later
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
        + "\nmessage: " + message;
    }
}
