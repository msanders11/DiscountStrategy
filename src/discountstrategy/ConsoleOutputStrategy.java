/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
