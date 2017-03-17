
package discountstrategy;

/**
 *
 * @author L115student
 */
public class ConsoleOutputStrategy implements ReceiptOutputStrategy {

    @Override
    public final void outputReceipt(final String receiptData) {
        if(receiptData == null){
            throw new IllegalArgumentException("Invalid or incorrect receipt data");
        }
        System.out.println(receiptData);
    }
}
