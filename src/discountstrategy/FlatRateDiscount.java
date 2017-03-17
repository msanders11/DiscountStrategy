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

    public FlatRateDiscount(final double flatRateDiscount) {
        setFlatRateDiscount(flatRateDiscount);
    }
    
    @Override
    public final double getDiscount(final Double retailPrice, final int qty) {
        if(retailPrice == null || retailPrice < 0 || qty < 0){
            throw new IllegalArgumentException("Invalid discount or qty passed to getDiscount");
        }
        return flatRateDiscount * qty;
    }

    public final double getFlatRateDiscount() {
        return flatRateDiscount;
    }

    public final void setFlatRateDiscount(final double flatRateDiscount) {
        if(flatRateDiscount == 0){
            throw new IllegalArgumentException("Invalid flat rate discount");
        }
        this.flatRateDiscount = flatRateDiscount;
    }
    
}
