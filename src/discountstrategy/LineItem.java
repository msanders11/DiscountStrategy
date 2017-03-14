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
public class LineItem {
    private Product product;
    private int qty;
    

    public LineItem(String productId, int qty, DataAccessStrategy db) {
        product = findProduct(productId, db);
        setQty(qty);
    }

    private Product findProduct(String productId, DataAccessStrategy db){
        return db.findProduct(productId);
    }
    
    public final String getLineItemData(){
        String data = "";
        data += product.getProductId()+ "   " + "\n";
        data += product.getName() + "   " + "\n";
        data += product.getRetailPrice() + "   " + "\n";
        data += qty + "   " + "\n";
        data += getSubtotal()+ "   " + "\n";
        data += product.getDiscountStrategy().getDiscount(product.getRetailPrice(), qty);
        return data;
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        this.qty = qty;
    }
    
    public final double getSubtotal(){
        return product.getRetailPrice() * qty;
    }
    
    
}
