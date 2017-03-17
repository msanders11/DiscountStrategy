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
public interface DiscountStrategy {
    
    public abstract double getDiscount(final Double retailPrice, final int qty);
    
}
