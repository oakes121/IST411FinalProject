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
public class ShippingCalc {
    
    public float getRate(int zip, float lb)
    {
        int startZip = 17402;
        float rate = ((startZip - zip)/1000 +1) * lb;
        return rate;   
    }
}

