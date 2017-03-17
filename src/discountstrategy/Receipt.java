
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
    private FormatReceiptStrategy formatter;

    public Receipt(final String customerId, final DataAccessStrategy db, final FormatReceiptStrategy formatter) {
        setDb(db);
        customer = findCustomer(customerId);
        lineItems = new LineItem[0];
        setFormatter(formatter);
        receiptNumber++;
    }

    private final Customer findCustomer(final String customerId) {
        return db.findCustomer(customerId);
    }
    
//    public final void startSale(final String customerId, final DataAccessStrategy db) {
//        receiptNumber++;
//        db.findCustomer(customerId);
//    }

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
        return formatter.getFormattedData(this);
//        Double netTotal = 0.0;
//        Double totalDiscount = 0.0;
//        
//        String storeInfo = "Thank you for shopping at Kohl's!";
//        String receiptData = storeInfo + "\n\n";
//        receiptData += "Sold to: " + ((customer == null) ? "" : customer.getName()) + "\n";
//        receiptData += "Receipt Number: " + receiptNumber + "\n\n";
//        receiptData += "ID      " + "Item              " + "Price  " + " Qty        " +
//                "Subtotal     " + "Discount" +"\n";
//        receiptData += "---------------------------------------------------------------------" + "\n";
//        for (LineItem item : lineItems) {
//            receiptData += item.getLineItemData() + "\n";
//            netTotal += item.getSubtotal();
//            totalDiscount += item.getProduct().getDiscountStrategy().getDiscount(item.getProduct().getRetailPrice(), item.getQty());
//        }
//        receiptData += "                                      ---------------" + "\n";
//        receiptData += "                                      Net Total:     " + String.format("$%,.2f", netTotal) +"\n";
//        receiptData += "                                      Amount Saved:  " + String.format("$%,.2f", totalDiscount) + "\n";
//        receiptData += "                                      --------------------" + "\n";
//        receiptData += "                                      Total Due: " + String.format("$%,.2f",(netTotal - totalDiscount));
//        return receiptData;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(final Customer customer) {
        //no customer validation as it is not needed to continue with sale
        this.customer = customer;
    }

    public final DataAccessStrategy getDb() {
        return db;
    }

    public final void setDb(final DataAccessStrategy db) {
        if(db == null){
            throw new IllegalArgumentException("No Data Access Strategy provided.");
        }
        this.db = db;
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(final LineItem[] lineItems) {
        if(lineItems == null){
            throw new IllegalArgumentException("Invalid or no lineItem provided");
        }
        this.lineItems = lineItems;
    }

    public final static int getReceiptNumber() {
        return receiptNumber;
    }

    public final static void setReceiptNumber(final int receiptNumber) {
        if(receiptNumber <= 0){
            throw new IllegalArgumentException("Invalid receipt number provided");
        }
        Receipt.receiptNumber = receiptNumber;
    }

    public final FormatReceiptStrategy getFormatter() {
        return formatter;
    }

    public final void setFormatter(final FormatReceiptStrategy formatter) {
        if(formatter == null){
            throw new IllegalArgumentException("Invalid formatter provided");
        }
        this.formatter = formatter;
    }
    
    
}
