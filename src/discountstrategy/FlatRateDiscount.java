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
public class FlatRateDiscount implements DiscountStrategy {
    private double flatRateDiscount;

    public FlatRateDiscount(double flatRateDiscount) {
        this.flatRateDiscount = flatRateDiscount;
    }
    
    @Override
    public final double getDiscount(Double retailPrice, int qty) {
        return flatRateDiscount * qty;
    }

    public final double getFlatRateDiscount() {
        return flatRateDiscount;
    }

    public final void setFlatRateDiscount(double flatRateDiscount) {
        this.flatRateDiscount = flatRateDiscount;
    }
    
}
