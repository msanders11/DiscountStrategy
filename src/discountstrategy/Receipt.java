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
public class Receipt {

    private Customer customer;
    private DataAccessStrategy db;
    private String receiptId;
    private LineItem[] lineItems;

    Receipt(String customerId, DataAccessStrategy db) {
        customer = new Customer(customerId, db);
    }

    public final Customer startSale(String customerId, DataAccessStrategy db) {
        return db.findCustomer(customerId);
    }

    public final void addItemToSale(String productId, int qty) {
        lineItems = new LineItems(productId, qty, db);
    }

    
}
