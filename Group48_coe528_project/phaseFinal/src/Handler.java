import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author kggur
 */

public class Handler {
    private String username;
    private String password;
    private double points;
    private String bookName;
    private double bookPrice;
    private int bookQuantity;
    public User current;
    public Customer c1;
    public ObservableList<Product> product = FXCollections.observableArrayList();
    
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
        
    }
    
    public void deleteCustomer(String user, String pass, double points){
        
    }    
    
    
    
    public void deleteBook(String name, String price, int quantity){
       
    }  
    
    public ObservableList<Product> getProduct (){
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader("books.txt"));
            
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                String info[] = line.split(", ");
                bookName = info[0];
                bookPrice = Double.parseDouble(info[1]);
                bookQuantity = Integer.parseInt(info[2]);
                
                product.add(new Product(bookName, bookPrice, bookQuantity));
                
                // read next line
                line = reader.readLine();
            }
            reader.close();
            
        } catch (Exception e){
            System.out.println("Invalid");
        } 

        return product;
    }
    
    public void addBook(String title, double price, int quantity) {
        product.add(new Product(title, price, quantity));
        
    }
    
    public ObservableList<Customer> getCustomers (){
        ObservableList<Customer> customers = FXCollections.observableArrayList();

        try{
            BufferedReader reader = new BufferedReader(new FileReader("customers.txt"));
            
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                String info[] = line.split(", ");
                username = info[0];
                password = info[1];
                points = Double.parseDouble(info[2]);
                
                customers.add(new Customer(username, password, points));
                
                // read next line
                line = reader.readLine();
            }
            reader.close();
            
        } catch (Exception e){
            System.out.println("Invalid");
        } 

        return customers;
    }
    
}