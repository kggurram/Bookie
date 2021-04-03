import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author kggur
 */

public class Handler {
    private String username;
    private String password;
    private String dir = "customers";
    private int points;
    private User current;
    public Customer c1;
    
    public boolean verify(String user, String pw) {
        boolean verification;
        verification = false;
               
        try{
            BufferedReader reader = new BufferedReader(new FileReader("customers.txt"));
            
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                String info[] = line.split(", ");
                username = info[0];
                password = info[1];
                points = Integer.parseInt(info[2]);
                c1 = new Customer(username, password, points);
                if((user.equals(username)) && (pw.equals(password))){
                    verification = true;
                    current = c1;
                    System.out.println(current.getUsername());
                    System.out.println(current.getPassword());
                    System.out.println(current.getPoints());
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();
            
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
    
    public ObservableList<Product> getProduct (){
        ObservableList<Product> product = FXCollections.observableArrayList();
        product.add(new Product("Harry Potter", 21.99, 3));
        product.add(new Product ("Obama", 24.99, 50));
        product.add(new Product("Baby Shark", 9.49, 1 ));
        return product;
    }
    
}