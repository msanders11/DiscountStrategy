
package discountstrategy;


/**
 *
 * @author msanders11
 */
public class StartUp {

    public static void main(String[] args) {
        DataAccessStrategy db = new InMemoryDataAccess();
        ReceiptOutputStrategy output = new ConsoleOutputStrategy();
        //start sale
        PosTerminal pos = new PosTerminal(output);
        pos.startSale("100", db);
        //add product
        pos.addItemtoSale("M101", 2);
        //add product
        pos.addItemtoSale("S206", 1);
        //end sale
        pos.endSale();
    }
}
