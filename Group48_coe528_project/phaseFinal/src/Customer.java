/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kggur
 */
public abstract class Customer {
    //add comment
    abstract public boolean login(String username, String password);
    
    abstract public boolean logout();
    
    abstract public boolean deposit(int amount);
    
    abstract public boolean withdraw(int amount);
    
    abstract public String getUsername();
    
    abstract public String getPassword();
    
    abstract public int getBalance();
    
    abstract public boolean purchase(int price);
   
    
}