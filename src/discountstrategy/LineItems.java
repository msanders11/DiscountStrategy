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
public class LineItems {
    private Product product;

    public LineItems(String productId, int qty, DataAccessStrategy db) {
        product = findProduct(productId, db);
    }

    public final Product findProduct(String productId, DataAccessStrategy db ){
        return db.findProduct(productId);
    }
    
    public final void addToLineItem(){
        String data = "";
        
    }




    
}
