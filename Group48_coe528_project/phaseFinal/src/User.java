/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kggur
 */
public abstract class User {
    
    abstract public boolean login(String username, String password);
    
    abstract public boolean logout();
    
    abstract public String getUsername();
    
    abstract public String getPassword();
    
}
