
package discountstrategy;

/**
 *
 * @author Mike
 */
public interface DataAccessStrategy {

    public abstract Customer findCustomer(String customerId);
    
    public abstract Product findProduct(String productId);
    
}
