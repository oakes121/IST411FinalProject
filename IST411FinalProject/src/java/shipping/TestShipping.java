/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shipping;

/**
 *
 * @author Nathan
 */
public class TestShipping {
    public static void main (String args[])
    {
        ShippingCalc ship = new ShippingCalc();
        System.out.println(String.valueOf(ship.getRate(20998, 3)));
    }
    
}
