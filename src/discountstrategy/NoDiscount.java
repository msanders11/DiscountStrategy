/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Mike
 */
public class NoDiscount implements DiscountStrategy {

    @Override
    public final double getDiscount(final Double retailPrice, final int qty) {
        if(retailPrice == null || retailPrice <=0){
            throw new IllegalArgumentException("Invalid retail price");
        }
        if(qty <= 0){
            throw new IllegalArgumentException("Invalid quantity");
        }
        return 0;
    }
    
}
