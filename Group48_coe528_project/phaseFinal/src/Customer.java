/**
 * @author Group 48 - Karthik, Waqas, Manav, Rania
 */

public class Customer extends User {

    private String username;
    private String password;
    private int points;

    public Customer (String username, String password, int points){
        this.username = username;
        this.password = password;
        this.points = points;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public int getPoints(){
        return points;
    }           
        
}