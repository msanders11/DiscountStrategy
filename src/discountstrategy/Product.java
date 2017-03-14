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
public class Product {
    private String name;
    private String productId;
    private double retailPrice;
    private DiscountStrategy discountStrategy;

    public Product(String productId, String name, double retailPrice, DiscountStrategy discount) {
        this.productId = productId;
        this.name = name;
        this.retailPrice = retailPrice;
        this.discountStrategy = discount;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId) {
        this.productId = productId;
    }

    public final double getRetailPrice() {
        return retailPrice;
    }

    public final void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    } 
    
    
    
}
