/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author msanders11
 */
public class DetailedFormatReceiptStrategy implements FormatReceiptStrategy {

    @Override
    public final String getFormattedData(final Receipt receipt) {
        if(receipt == null){
            throw new IllegalArgumentException("No or Invalid receipt provided");
        }
        Double netTotal = 0.0;
        Double totalDiscount = 0.0;

        String storeInfo = "Thank you for shopping at Kohl's!";
        String receiptData = storeInfo + "\n\n";
        receiptData += "Sold to: " + ((receipt.getCustomer() == null) ? "" : receipt.getCustomer().getName()) + "\n";
        receiptData += "Receipt Number: " + Receipt.receiptNumber + "\n\n";
        receiptData += "ID      " + "Item              " + "Price  " + " Qty        "
                + "Subtotal     " + "Discount" + "\n";
        receiptData += "---------------------------------------------------------------------" + "\n";
        for (LineItem item : receipt.getLineItems()) {
            receiptData += item.getLineItemData() + "\n";
            netTotal += item.getSubtotal();
            totalDiscount += item.getProduct().getDiscountStrategy().getDiscount(item.getProduct().getRetailPrice(), item.getQty());
        }
        receiptData += "                                      ---------------" + "\n";
        receiptData += "                                      Net Total:     " + String.format("$%,.2f", netTotal) + "\n";
        receiptData += "                                      Amount Saved:  " + String.format("$%,.2f", totalDiscount) + "\n";
        receiptData += "                                      --------------------" + "\n";
        receiptData += "                                      Total Due: " + String.format("$%,.2f", (netTotal - totalDiscount));
        return receiptData;
    }
}
