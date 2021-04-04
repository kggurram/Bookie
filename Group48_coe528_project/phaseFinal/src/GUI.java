/**
 * @author Group 48 - Karthik, Waqas, Manav, Rania
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
                }else if (handler.verify(username, password)){ //will create a verify method in the manager class to check for login credentials
                    
                    customerWindow(primaryStage, handler);
                    System.out.println("Customer successfully logged in.");
                    
                }else{
                    System.out.println("Invalid Login.");
                    System.out.println(username);
                    System.out.println(password);
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

        Text scenetitle = new Text("Welcome, Administrator");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
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
        
        managerPane.add(scenetitle, 0, 0, 2, 1);
        
        books.setOnAction((ActionEvent e)->{
            managerBooks(primaryStage, handler);
        });
        
        customers.setOnAction((ActionEvent e)->{
            managerCustomers(primaryStage, handler);
        });
       
        logout.setOnAction((ActionEvent e) -> {
            start(primaryStage);
        });
        
        Scene scene = new Scene(managerPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    //Rania & Manav
    public void customerWindow(Stage primaryStage, Handler a){
        Handler handler = new Handler();

        Text scenetitle = new Text("Welcome, Customer");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Button buy = new Button("Buy");
        Button redeemBuy = new Button("Redeem and Buy");
        Button logout = new Button("Logout");

        GridPane customerPane = new GridPane();
        
        customerPane.setAlignment(Pos.CENTER);
        customerPane.setHgap(10);
        customerPane.setVgap(10);
        customerPane.setPadding(new Insets(25, 25, 25, 25));
        
        customerPane.add(books, 0, 2);
        customerPane.add(customers, 0, 3);
        customerPane.add(logout, 0, 4);
        
        customerPane.add(scenetitle, 0, 0, 2, 1);
        
        books.setOnAction((ActionEvent e)->{
            managerBooks(primaryStage, handler);
        });
        
        customers.setOnAction((ActionEvent e)->{
            managerCustomers(primaryStage, handler);
        });
       
        logout.setOnAction((ActionEvent e) -> {
            start(primaryStage);
        });
        
        Scene scene = new Scene(customerPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    public void managerBooks(Stage primaryStage, Handler a){
        
        TableView<Product> bookTable;
        Handler handler = new Handler();
        
        //Title Column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Title");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));

        //Price Column
        TableColumn<Product, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity Column
        TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(75);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Select Column
        TableColumn<Product, CheckBox> selectColumn = new TableColumn("Select");
        selectColumn.setMinWidth(50);
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("select"));
        bookTable = new TableView<>();
        bookTable.setItems(handler.getProduct());
        bookTable.getColumns().addAll(nameColumn, priceColumn, quantityColumn, selectColumn );

        Button delete = new Button("Delete");
        Button back = new Button("Back");

        back.setOnAction((ActionEvent e)->{
            managerWindow(primaryStage, handler);
        });
        
        delete.setOnAction((ActionEvent e)->{
            //Delete book
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(bookTable, delete, back);
        vBox.setPadding(new Insets(35, 35, 35, 35));
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox);
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

    public static void main(String[] args){
        launch(args);
    }
    
}
