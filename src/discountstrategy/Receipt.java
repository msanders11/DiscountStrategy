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
    private int receiptNumber = 0;

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
        LineItem lineItem = new LineItem(productId, qty, db);
        addToArray(lineItem);
    }

    public final void addToArray(final LineItem lineItem) {
        
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = lineItem;
        lineItems = tempItems;
        tempItems = null;
    }

    public final String getReceiptData() {
        Double netTotal = 0.0;
        Double totalDiscount = 0.0;
        receiptNumber++;
        String storeInfo = "Thank you for shopping at Kohl's!";
        String receiptData = storeInfo + "\n\n";
        receiptData += "Sold to: " + ((customer.getName() == null) ? "" : customer.getName()) + "\n";
        receiptData += "Receipt Number: " + receiptNumber + "\n\n";
        receiptData += "ID    " + "Item            " + "Price   " + " Qty   " +
                "Subtotal     " + "Discount" +"\n";
        receiptData += "------------------------------------------------------";
        for (LineItem item : lineItems) {
            receiptData += item.getLineItemData() + "\n";
            netTotal += item.getSubtotal();
            totalDiscount += item.getProduct().getDiscountStrategy().getDiscount(item.getProduct().getRetailPrice(), item.getQty());
        }
        receiptData += "---------------";
        receiptData += "Net Total: " + netTotal +"\n";
        receiptData += "Amount Saved: " + totalDiscount + "\n";
        receiptData += "--------------------";
        receiptData += "Total Due: " + (netTotal - totalDiscount);
        
        return receiptData;
    }

}
