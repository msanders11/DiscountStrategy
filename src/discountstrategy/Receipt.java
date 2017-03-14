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
        customer = findCustomer(customerId, db);

        lineItems = new LineItem[0];
    }

    private Customer findCustomer(String customerId, DataAccessStrategy db) {
        return db.findCustomer(customerId);
    }

    public final Customer startSale(String customerId, DataAccessStrategy db) {
        return db.findCustomer(customerId);
    }

    public final void addLineItem(String productId, int qty) {
        LineItem lineItems = new LineItem(productId, qty, db);
        addToArray(lineItems);
    }

    private void addToArray(final LineItem lineItem) {
        // needs validation
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = lineItem;
        lineItems = tempItems;
        tempItems = null;
    }
    
    public final String getReceiptData(){
       String receiptData = "";
       for(LineItem item : lineItems){
           receiptData = item.getLineItemData() + "\n";
       }
        return receiptData;
    }

}
