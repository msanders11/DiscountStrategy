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

    public final Product findProduct(String productId, DataAccessStrategy db){
        return db.findProduct(productId);
    }
    
    public final void addDataToLineItem(){
        String data = "";
        
    }
    
    public final void addLineItem(){
        
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
    
    
}
