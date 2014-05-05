/**
 * IST 411 Exam 2
 * DITest.java
 * 
 * Purpose: This class tests DatabaseInterface.java
 * 
 * @author Oakes
 * @version 1.0 4/16/2014
 */

package databaseInterface;

import javax.swing.JOptionPane;

/**
 *
 * @author Oakes
 */
public class DITest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatabaseInterface dbi = new DatabaseInterface(1);
        /*
        for (int i = 0; i < dbi.getProducts().size(); i++) {
            JOptionPane.showMessageDialog(null, dbi.getProducts().get(0).getTitle()+"");
        }*/
        
    }
    
}
