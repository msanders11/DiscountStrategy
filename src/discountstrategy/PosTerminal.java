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
public class PosTerminal {
    private Receipt receipt;
    
    public final void startSale(String customerId, DataAccessStrategy db) {
        receipt = new Receipt(customerId, db);
    }

    public final void addItemtoSale(String productId, int qty) {
        receipt.addLineItem(productId, qty);
    }

    public final void endSale() {
        receipt.outPutReceipt();
    }
    
}
