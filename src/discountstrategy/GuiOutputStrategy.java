/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author L115student
 */
public class GuiOutputStrategy implements ReceiptOutputStrategy {

    @Override
    public final void outputReceipt(final String receiptData) {
        if(receiptData == null || receiptData.length() == 0){
            throw new IllegalArgumentException("Invalid receipt data.");
        }
        JOptionPane.showMessageDialog(null, receiptData);
    }
}
