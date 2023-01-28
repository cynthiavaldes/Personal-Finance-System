/**
 * @author Cynthia Valdes
 */

public class userInfo {
    static String username;
    static String pin;
    static int ID;
    
    public static void setUsername(String userText){
        username = userText;
    }
    
    public static String getUsername(){
        return username;
    }
    
    public static int getID(){
        return ID;
    }
    
    public static void setID(int IDText){
        ID = IDText;
    }
    
    /**public static void setPin(String pinText){
        pin = pinText;
    }
    
    public static String getPin(){
        return pin;
    }*/
}
