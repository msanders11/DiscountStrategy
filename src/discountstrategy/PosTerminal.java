package discountstrategy;

/**
 *
 * @author Mike
 */
public class PosTerminal {

    private Receipt receipt;
    private ReceiptOutputStrategy output;

    public PosTerminal(ReceiptOutputStrategy output) {
        this.output = output;
    }

    public final void startSale(String customerId, DataAccessStrategy db) {
//        if (customerId == null || customerId.length() == 0) {
//            throw new IllegalArgumentException("Invalid or no customerId entered.");
//        }
        if (db == null) {
            throw new IllegalArgumentException("No Data Access provided.");
        }
        receipt = new Receipt(customerId, db);
    }

    public final void addItemToSale(String productId, int qty) {
        if (productId == null || productId.length() == 0) {
            throw new IllegalArgumentException("Invalid product ID.");
        }
        if (qty <= 0) {
            throw new IllegalArgumentException("Invalid quantity.");
        }
        receipt.addLineItem(productId, qty);
    }

    public final void endSale() {
        output.outputReceipt(receipt.getReceiptData());
    }

}
