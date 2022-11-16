// Data Class for Clack
// Andrew Tringali
// Last modified 11/15/22

package data;
import java.io.Serializable;
import java.util.Date;

public abstract class ClackData implements Serializable {
    
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
    public abstract String getData();

    /**
     * Overloaded in MessageClackData and FileClackData
     */
    public abstract String getData(String key);

    /**
     *  Encrypt: Takes input string and key, outputs encrypted string
    */ 
    protected String encrypt(String inputStringToEncrypt, String key) {
        String encrKey = "";
        String ciphText = "";

        while (encrKey.length() <= inputStringToEncrypt.length()) {
            encrKey += key;
        }

        for (int i = 0; i < inputStringToEncrypt.length(); i++) {
            int q = ((inputStringToEncrypt.charAt(i) + encrKey.charAt(i)) % 255);
            ciphText += (char) q;
        }

        return ciphText;
    }

    /**
     *  Decrypt: Takes input string and key, outputs decrypted string
    */ 
    protected String decrypt(String inputStringToDecrypt, String key){
        String encrKey = "";
        String decrText = "";

        while (encrKey.length() <= inputStringToDecrypt.length()) {
            encrKey += key;
        }

        for (int i=0; i < inputStringToDecrypt.length(); i++) {
            int q = ((inputStringToDecrypt.charAt(i) - encrKey.charAt(i) + 255) % 255);
            decrText += (char) q;
        }
        return decrText;
    }

    /**
     * Internal method to verify the encryption is working
     */

    public Boolean verifyEncrypt() {
        String phrase = "This is a simple test phrase";
        String key = "TC1l0X";
        String encr = encrypt(phrase, key);
        String decr = decrypt(encr, key);

        // prints values
        System.out.println("test phrase: "+phrase);
        System.out.println("encrypted message: "+encr);
        System.out.println("decrypted message: "+decr);

        // check if encryption is working - return true or false
        if (decr.equals(phrase)) {
            return true;
        } else {
            return false;
        }
    }


}
