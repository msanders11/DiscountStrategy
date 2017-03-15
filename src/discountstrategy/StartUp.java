
package discountstrategy;


/**
 *
 * @author msanders11
 */
public class StartUp {

    public static void main(String[] args) {
        DataAccessStrategy db = new InMemoryDataAccess();
        ReceiptOutputStrategy output = new GuiOutputStrategy();
        //start sale
        PosTerminal pos = new PosTerminal(output);
        pos.startSale("100", db);
        //add product
        pos.addItemToSale("S206", 2);
        //add product
        pos.addItemToSale("A012", 1);
        //end sale
        pos.endSale();
        
        pos.startSale(" ", db);
        pos.addItemToSale("M101", 2);
        pos.addItemToSale("W456", 1);
        pos.endSale();
    }
}
