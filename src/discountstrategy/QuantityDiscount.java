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
public class QuantityDiscount implements DiscountStrategy {
    private double quantityDiscountAmount;

    public QuantityDiscount(double quantityDiscountAmount) {
        setQuantityDiscountAmount(quantityDiscountAmount);
    }
    
    @Override
    public final double getDiscount(Double retailPrice, int qty) {
        return quantityDiscountAmount * qty;
    }

    public final double getQuantityDiscountAmount() {
        return quantityDiscountAmount;
    }

    public final void setQuantityDiscountAmount(double quantityDiscountAmount) {
        this.quantityDiscountAmount = quantityDiscountAmount;
    }
    
    
}
