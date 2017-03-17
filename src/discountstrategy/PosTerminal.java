package discountstrategy;

/**
 *
 * @author Mike
 */
public class PosTerminal {

    private Receipt receipt;
    private ReceiptOutputStrategy output;
    private ReceiptOutputStrategy output2;
    

    public PosTerminal(ReceiptOutputStrategy output, ReceiptOutputStrategy output2) {
        this.output = output;
        this.output2 = output2;
    }

    public final void startSale(final String customerId, final DataAccessStrategy db) {
//        if (customerId == null || customerId.length() == 0) {
//            throw new IllegalArgumentException("Invalid or no customerId entered.");
//        }
        if (db == null) {
            throw new IllegalArgumentException("No Data Access provided.");
        }
        receipt = new Receipt(customerId, db);
    }

    public final void addItemToSale(final String productId, final int qty) {
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
        output2.outputReceipt(receipt.getReceiptData());
    }

}
