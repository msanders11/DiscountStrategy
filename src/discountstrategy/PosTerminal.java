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
        setOutput(output);
        setOutput2(output2);
    }

    public final void startSale(final String customerId, final DataAccessStrategy db, final FormatReceiptStrategy formatter) {
//        if (customerId == null || customerId.length() == 0) {
//            throw new IllegalArgumentException("Invalid or no customerId entered.");
//        }
        if (formatter == null) {
            throw new IllegalArgumentException("No receipt format provided.");
        }
        if (db == null) {
            throw new IllegalArgumentException("No Data Access provided.");
        }
        receipt = new Receipt(customerId, db, formatter);
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

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        if (receipt == null) {
            throw new IllegalArgumentException("No receipt.");
        }
        this.receipt = receipt;
    }

    public final ReceiptOutputStrategy getOutput() {
        return output;
    }

    public final void setOutput(ReceiptOutputStrategy output) {
        if (output == null) {
            throw new IllegalArgumentException("No or invalid output strategy provdided");
        }
        this.output = output;
    }

    public final ReceiptOutputStrategy getOutput2() {
        return output2;
    }

    public final void setOutput2(ReceiptOutputStrategy output2) {
        if (output2 == null) {
            throw new IllegalArgumentException("No or invalid output strategy provdided");
        }
        this.output2 = output2;
    }

}
