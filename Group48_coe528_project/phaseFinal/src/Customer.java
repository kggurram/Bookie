
import javafx.scene.control.CheckBox;

/**
 * @author Group 48 - Karthik, Waqas, Manav, Rania
 */

public class Customer extends User {

    private String username;
    private String password;
    private double points;
    private CheckBox select = new CheckBox();

    public Customer (String username, String password, double points){
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
    
    public double getPoints(){
        return points;
    }           
    
    public CheckBox getSelect(){
        return select;
    }

    public void setSelect(CheckBox select){
        this.select = select;
    }
}