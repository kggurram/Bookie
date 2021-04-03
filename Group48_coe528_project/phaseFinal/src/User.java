/**
 * @author Group 48 - Karthik, Waqas, Manav, Rania
 */

public abstract class User {
    
    abstract public boolean login(String username, String password);
    
    abstract public boolean logout();
    
    abstract public String getUsername();
    
    abstract public String getPassword();
    
}
