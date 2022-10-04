// Message Data for Clack
// Andrew Tringali 10/3/22

package data;

public class MessageClackData extends ClackData {
    
    //  members
    private String message;

    // constructors
    public MessageClackData(String cUsername, String cMessage, int cType){
        super(cUsername, cType);
        this.message = cMessage;
    }

    // default constructor
    public MessageClackData(){
        super();
    }

    // methods


    public String getData(){
        return message;
    }

    public int hashCode() {
        return 0; // rewrite
    }

    public boolean equals(Object other){
        MessageClackData otherData = (MessageClackData)other;
        return this.message == otherData.message && this.getUserName() == otherData.getUserName() && this.getType() == otherData.getType() && this.getDate() == otherData.getDate(); // revisit this later
    }

    public String toString(){
        return "username: " + super.getUserName() 
        + "\ntype: " + super.getType() 
        + "\ndate: " + super.getDate() 
        + "\nmessage: " + message; // return full description of class with all instance variables (including super class)
    }

}
