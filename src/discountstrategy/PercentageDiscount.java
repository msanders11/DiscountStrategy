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
public class PercentageDiscount implements DiscountStrategy{
    private double discountPercent;

    public PercentageDiscount(final double discountPercent) {
        setDiscountPercent(discountPercent);
    }

    @Override
    public final double getDiscount(final Double retailPrice, final int qty) {
        if(retailPrice == null || retailPrice < 0){
            throw new IllegalArgumentException("Invalid retail price");
        }
        if(qty <= 0){
            throw new IllegalArgumentException("Invalid quantity");
        }
        return (retailPrice * discountPercent) * qty; 
    }

    public final double getDiscountPercent() {
        return discountPercent;
    }

    public final void setDiscountPercent(final double discountPercent) {
        if(discountPercent < 0 || discountPercent >= 1){
            throw new IllegalArgumentException("Invalid discount percent");
        }
        this.discountPercent = discountPercent;
    }
    
    
}
