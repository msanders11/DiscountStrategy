
package discountstrategy;


/**
 *
 * @author msanders11
 */
public class StartUp {

    public static void main(String[] args) {
        DataAccessStrategy db = new InMemoryDataAccess();
        //start sale
        PosTerminal pos = new PosTerminal();
        pos.startSale("200", db);
        //add product
        pos.addItemtoSale("A101", 2);
        //add product
        pos.addItemtoSale("B201", 1);
        //end sale
        pos.endSale();
    }
}
