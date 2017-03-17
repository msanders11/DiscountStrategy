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
    private final int minimumQuantity = 5;
    private int qty;

    public QuantityDiscount(final double quantityDiscountAmount, final int qty) {
        setQuantityDiscountAmount(quantityDiscountAmount);
        setQty(qty);
    }
    
    @Override
    public final double getDiscount(final Double retailPrice, final int qty) {
        if(qty >= minimumQuantity){
            return (quantityDiscountAmount * retailPrice) * qty;
        }
        quantityDiscountAmount = 0;
        return quantityDiscountAmount;
    }

    public final double getQuantityDiscountAmount() {
        return quantityDiscountAmount;
    }

    public final void setQuantityDiscountAmount(final double quantityDiscountAmount) {
        if(quantityDiscountAmount <= 0 || quantityDiscountAmount >= 1){
            throw new IllegalArgumentException("Invalid discount amount");
        }
        this.quantityDiscountAmount = quantityDiscountAmount;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(final int qty) {
        if(qty <= 0){
            throw new IllegalArgumentException("Enter a valid quantity");
        } 
        this.qty = qty;
    }    
}
