
package discountstrategy;


/**
 *
 * @author msanders11
 */
public class StartUp {

    public static void main(String[] args) {
        DataAccessStrategy db = new InMemoryDataAccess();
        ReceiptOutputStrategy output = new GuiOutputStrategy();
        ReceiptOutputStrategy output2 = new ConsoleOutputStrategy();
        FormatReceiptStrategy formatter = new DetailedFormatReceiptStrategy();
        FormatReceiptStrategy formatter2 = new BriefFormatReceiptStrategy();
        //start sale
        PosTerminal pos = new PosTerminal(output, output2);
        pos.startSale("100", db, formatter);
        //add product
        pos.addItemToSale("S206", 2);
        //add product
        pos.addItemToSale("A012", 2);
        //end sale
        pos.endSale();
        
        pos.startSale("", db, formatter2);
        pos.addItemToSale("M101", 2);
        pos.addItemToSale("W456", 1);
        pos.endSale();
    }
}
