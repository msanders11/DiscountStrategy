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

    public Product(final String productId, final String name, final double retailPrice, final DiscountStrategy discount) {
        setProductId(productId);
        setName(name);
        setRetailPrice(retailPrice);
        setDiscountStrategy(discount);
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        if(name == null || name.length() == 0){
            throw new IllegalArgumentException("Invalid, no product name provided.");
        }
        this.name = name;
    }

    public final String getProductId() {
        return productId;
    }

    public final void setProductId(final String productId) {
        if(productId == null || productId.length() == 0 || productId.length() > 4){
            throw new IllegalArgumentException("Invalid or incorrect producdId ");
        }
        this.productId = productId;
    }

    public final double getRetailPrice() {
        return retailPrice;
    }

    public final void setRetailPrice(final double retailPrice) {
        if(retailPrice < 0){
            throw new IllegalArgumentException("Invalid retail price.");
        }
        this.retailPrice = retailPrice;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(final DiscountStrategy discountStrategy) {
        if(discountStrategy == null){
            throw new IllegalArgumentException("Invalid discount strategy");
        }
        this.discountStrategy = discountStrategy;
    } 
    
    
    
}
