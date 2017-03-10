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
    private LineItem[] lineItem;
    private ReceiptOutputStrategy outputStrategy;

    Receipt(String customerId, DataAccessStrategy db) {
        customer = findCustomer(customerId, db);

        lineItem = new LineItem[0];
    }

    private Customer findCustomer(String customerId, DataAccessStrategy db) {
        return db.findCustomer(customerId);
    }

    public final Customer startSale(String customerId, DataAccessStrategy db) {
        return db.findCustomer(customerId);
    }

    public final void addLineItem(String productId, int qty) {
        LineItem lineItem = new LineItem(productId, qty, db);
        addToArray(lineItem);
    }

    private void addToArray(LineItem lineItem) {
        // needs validation
        LineItem[] tempItems = new LineItem[lineItem.length + 1];
        System.arraycopy(lineItem, 0, tempItems, 0, lineItem.length());
        tempItems[lineItem.length] = lineItem;
        lineItem = tempItems;
        tempItems = null;
    }

    void outPutReceipt() {
        String receiptData = "";
        outputStrategy.outputReceipt(receiptData);
    }

}
