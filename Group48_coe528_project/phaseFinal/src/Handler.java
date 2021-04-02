/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
/**
 *
 * @author kggur
 */
public class Handler {
    private String username;
    private String password;
    private String dir = "customerFile";
    private int bal;
    private Customer current;
    
    //handlers can add or delete a customer

    public boolean verify(String u, String pw) {
        boolean verification;
        verification = false;
        try{
            FileReader readFile = new FileReader(dir + u + ".txt");
            BufferedReader buffer1 = new BufferedReader(readFile);
            
            String line = buffer1.readLine();
            String info[] = line.split(", ");
            
            username = info[0];
            password = info[1];
            bal = Integer.parseInt(info[2]);

        } catch (Exception e){
            System.out.println("User doesn't exist");
        } return verification;
      
    }
    
    public void addCustomer(String user, String pass) {
        String newDirectory = dir + user +  ".txt";
        File customerFile = new File(newDirectory);
        try {
            FileWriter writeToFile = new FileWriter(customerFile);
            BufferedWriter writer = new BufferedWriter(writeToFile);
            
            writer.write(user + ", " + pass + ", " + 100);
        
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Error creating new user file.");
        }
    }
    
    public void deleteCustomer(String user, String pass){
        File dFile = new File(dir + user + ".txt");
        try{
            if(dFile.delete()){
              System.out.println("Deleted user.");  
            } else{
                throw new Exception();
            }
        } catch (Exception e){
            System.out.println("Error");
        }
    }
    
    public boolean logout(){
        return current.logout();
    }
      
    public String getCustomerUserName(){
        return current.getUsername();
    }
    
}