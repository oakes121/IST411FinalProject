/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package creditCardValidation;

import java.util.Scanner;

/**
 *
 * @author Oakes Isaac
 */
public class CreditCardValidationTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        System.out.println(CreditCardValidation.validate(input.next()) ? "You have entered a valid credit/debit card number" 
                : "You have entered an invalid credit/debit card number");
    }
    
}
