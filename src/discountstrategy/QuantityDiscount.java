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
    private int qty;

    public QuantityDiscount(double quantityDiscountAmount, int qty) {
        setQuantityDiscountAmount(quantityDiscountAmount);
        setQty(qty);
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

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        if(qty <= 0){
            throw new IllegalArgumentException("Enter a valid quantity");
        } 
        this.qty = qty;
    }
    
    
}
