// Message Data for Clack
// Andrew Tringali 10/3/22

package data;

public class MessageClackData extends ClackData {
    
    //  members
    private String message;

    /*
     * Passes given name and action type to superconstructor
     * Also creates MessageClackData suboject with message set to "cMessage" string
     */
    public MessageClackData(String cUsername, String cMessage, int cType){
        super(cUsername, cType);
        this.message = cMessage;
    }

    /*
     * Default constructor; just calls superconstructor with no arguments
     */
    public MessageClackData(){
        super();
    }

    // methods

    /*
     * Returns the contents of message
     */
    public String getData(){
        return message;
    }

    /*
     * hashcode() override
     */
    public int hashCode() {
        return 0; // rewrite
    }

    /*
     * equals() override
     */
    public boolean equals(Object other){
        MessageClackData otherData = (MessageClackData)other;
        return this.message == otherData.message && this.getUserName() == otherData.getUserName() && this.getType() == otherData.getType() && this.getDate() == otherData.getDate(); // revisit this later
    }

    /*
     * toString() override
     * returns a full description of the class with all instance variables (including those in the super class)
     */
    public String toString(){
        return "username: " + super.getUserName() 
        + "\ntype: " + super.getType() 
        + "\ndate: " + super.getDate() 
        + "\nmessage: " + message;
    }

}
