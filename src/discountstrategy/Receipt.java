
package discountstrategy;

/**
 *
 * @author Mike
 */
public class Receipt {

    private Customer customer;
    private DataAccessStrategy db;
    private LineItem[] lineItems;
    public static int receiptNumber = 0;

    Receipt(final String customerId, final DataAccessStrategy db) {
        this.db = db;
        customer = findCustomer(customerId);

        lineItems = new LineItem[0];
    }

    private final Customer findCustomer(final String customerId) {
        return db.findCustomer(customerId);
    }
    
    public final void startSale(final String customerId, final DataAccessStrategy db) {
        receiptNumber++;
        db.findCustomer(customerId);
    }

    public final void addLineItem(final String productId, int qty) {
        if(productId == null || productId.length() == 0){
            throw new IllegalArgumentException("Invalid product ID.");
        } 
        if(qty <= 0){
            throw new IllegalArgumentException("Invalid quantity.");
        }
        LineItem lineItem = new LineItem(productId, qty, db);
        addToArray(lineItem);
    }

    public final void addToArray(final LineItem lineItem) {
        if(lineItem == null){
            throw new IllegalArgumentException("Invalid lineItem");
        }
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = lineItem;
        lineItems = tempItems;
        tempItems = null;
    }

    public final String getReceiptData() {
        Double netTotal = 0.0;
        Double totalDiscount = 0.0;
        
        String storeInfo = "Thank you for shopping at Kohl's!";
        String receiptData = storeInfo + "\n\n";
        receiptData += "Sold to: " + ((customer == null) ? "" : customer.getName()) + "\n";
        receiptData += "Receipt Number: " + receiptNumber + "\n\n";
        receiptData += "ID      " + "Item              " + "Price  " + " Qty        " +
                "Subtotal     " + "Discount" +"\n";
        receiptData += "---------------------------------------------------------------------" + "\n";
        for (LineItem item : lineItems) {
            receiptData += item.getLineItemData() + "\n";
            netTotal += item.getSubtotal();
            totalDiscount += item.getProduct().getDiscountStrategy().getDiscount(item.getProduct().getRetailPrice(), item.getQty());
        }
        receiptData += "                                      ---------------" + "\n";
        receiptData += "                                      Net Total:     " + String.format("$%,.2f", netTotal) +"\n";
        receiptData += "                                      Amount Saved:  " + String.format("$%,.2f", totalDiscount) + "\n";
        receiptData += "                                      --------------------" + "\n";
        receiptData += "                                      Total Due: " + String.format("$%,.2f",(netTotal - totalDiscount));
        return receiptData;
    }

}
