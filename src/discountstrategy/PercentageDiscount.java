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

    public PercentageDiscount(double discountPercent) {
        setDiscountPercent(discountPercent);
    }

    @Override
    public final double getDiscount(Double retailPrice, int qty) {
        return (retailPrice * discountPercent) * qty; 
    }

    public final double getDiscountPercent() {
        return discountPercent;
    }

    public final void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
    
    
}
