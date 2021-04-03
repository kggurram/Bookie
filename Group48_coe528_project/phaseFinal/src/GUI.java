/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * @author Group 48 - Karthik, Waqas, Manav, Rania
 */

public class GUI extends Application {
    
    @Override
    public void start(Stage primaryStage){ 
        
        primaryStage.setTitle("Bookstore App");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Welcome to the Bookstore App");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label UserName = new Label("User Name:");
        grid.add(UserName, 0, 1);
        TextField userbox = new TextField();
        grid.add(userbox, 1, 1);

        Label Password = new Label("Password:");
        grid.add(Password, 0, 2);
        PasswordField pwbox = new PasswordField();
        grid.add(pwbox, 1, 2);

        Label invalid = new Label("Invalid Login");

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        Handler handler = new Handler();
        
        btn.setOnAction(new EventHandler<ActionEvent>(){
        
            @Override
            public void handle(ActionEvent event){
                
                String username = userbox.getText();
                String password = pwbox.getText();
                
               
                if (username.equals("admin") && password.equals("admin")){
                    managerWindow(primaryStage, handler);
                    System.out.println("Admin successfully logged in.");

                } 
                else if (username.equals(username) && password.equals(password))
                {
                    customerWindow(primaryStage, handler);
                    System.out.println(username + " has successfully logged in.");
                    
                }

                else{
                System.out.println("Invalid Login.");
                System.out.println(UserName.getText());
                System.out.println(Password.getText());
                grid.add(invalid, 1, 3);
                }
                
               
                
                
            }
        });
        
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void managerWindow(Stage primaryStage, Handler a){

        Handler handler = new Handler();
        
        Button books = new Button("Books");
        Button customers = new Button("Customers");
        Button logout = new Button("Logout");

        GridPane managerPane = new GridPane();
        
        managerPane.setAlignment(Pos.CENTER);
        managerPane.setHgap(10);
        managerPane.setVgap(10);
        managerPane.setPadding(new Insets(25, 25, 25, 25));
        
        managerPane.add(books, 0, 2);
        managerPane.add(customers, 0, 3);
        managerPane.add(logout, 0, 4);
        
        books.setOnAction((ActionEvent e)->{
            managerBooks(primaryStage, handler);
        });
        
        customers.setOnAction((ActionEvent e)->{
            managerCustomers(primaryStage, handler);
        });
       
        logout.setOnAction((ActionEvent e) -> {
            start(primaryStage);
        });
        
        Scene scene = new Scene(managerPane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    public void managerBooks(Stage primaryStage, Handler a){
        
        Handler handler = new Handler();
        
        Button back = new Button("Back");
        GridPane managerBooksPane = new GridPane();
        
        managerBooksPane.setAlignment(Pos.CENTER);
        managerBooksPane.setHgap(10);
        managerBooksPane.setVgap(10);
        managerBooksPane.setPadding(new Insets(25, 25, 25, 25));
        
        managerBooksPane.add(back, 0, 2);
        
        back.setOnAction((ActionEvent e)->{
            managerWindow(primaryStage, handler);
        });
        
        Scene scene = new Scene(managerBooksPane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void managerCustomers(Stage primaryStage, Handler a){
        
        Handler handler = new Handler();
        
        Button back = new Button("Back");
        GridPane managerCustomersPane = new GridPane();
        
        managerCustomersPane.setAlignment(Pos.CENTER);
        managerCustomersPane.setHgap(10);
        managerCustomersPane.setVgap(10);
        managerCustomersPane.setPadding(new Insets(25, 25, 25, 25));
        
        managerCustomersPane.add(back, 0, 2);
        
        back.setOnAction((ActionEvent e)->{
            managerWindow(primaryStage, handler);
        });
        
        Scene scene = new Scene(managerCustomersPane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void customerWindow(Stage primaryStage, Handler a)
    {
       Button buy = new Button("Buy");
        Button redeemBuy = new Button("Redeem Points and Buy");
        Button logoutCustomer = new Button("Logout");
        
        GridPane customerPane = new GridPane();
    //    GridPane customerPane2 = new GridPane();
    //    GridPane customerPane3 = new GridPane();
        
        
        customerPane.setAlignment(Pos.BOTTOM_CENTER);

        
        customerPane.add(buy, 0,4);
        customerPane.add(redeemBuy, 10, 4);
        customerPane.add(logoutCustomer, 20, 4);
        
        buy.setOnAction((ActionEvent e) -> {
        });
        redeemBuy.setOnAction((ActionEvent e) -> {
        });
        logoutCustomer.setOnAction((ActionEvent e) -> {
            start(primaryStage);
        });
        
        
        
        
        Scene scene = new Scene(customerPane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public void customerStartScreen(Stage primaryStage, Handler a)
    {
        
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
