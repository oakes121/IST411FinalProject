/**
 * IST 411 Exam 2
 * DatabaseInterface.java
 * 
 * Purpose: This class uses a method to connect to a database and query the id that was
 *  passed in the parameter
 * 
 * @author Oakes
 * @version 1.0 4/16/2014
 */

package databaseInterface;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import product.Product;

public class DatabaseInterface {
    
    private ArrayList<Product> products;
    
    public DatabaseInterface(int id) {
        this.products = new ArrayList<Product>();        
        FindQuery(id);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    
    /**
     * FindQuery(int id) queries the table to find the record with the productID
     *  id
     * @param id the id that is to be found from the table
     */
    private void FindQuery(int id) {
        
        String className=null;
        String url=null;
        String user = null;
        String password = null;
        
        try
        {
            ResourceBundle resources;
            InputStream in;
            ResourceBundle newResources;

            //in = ClassLoader.getSystemResourceAsStream("db.properties");

            //resources = new PropertyResourceBundle(in);

            //in.close();

            className = "org.apache.derby.jdbc.ClientDriver";
            url = "jdbc:derby://localhost:1527/IST411";
            //System.out.println(url);
            user = "banana";
            password = "banana";
        }
        
        catch (Exception exp)
        {
            System.out.println("Couldn't load resources for some reason." + exp);
            System.exit(-1);
        }
        
        try
        {
            Class.forName(className);
        }
        catch (Exception e) 
        {
            System.out.println("Failed to load  driver.");
            return;
        }
        
        try
        {     
            Connection con = DriverManager.getConnection(url, user, password);     
                
            Statement stmt = con.createStatement();

            
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCT where PRODUCTCATEGORY_IDPRODUCTCATEGORY = " + id + "");
     
            while (rs.next())
            {        
                JOptionPane.showMessageDialog(null, rs.getString(2) + "" + rs.getString(3 + "" + rs.getString(4)));
                //products.add(new Product(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7)));
            }
            
            stmt.close();
        
            con.close();
        }
        catch (Exception e) 
        {
            //System.out.println(e);
        }
    }
}
