
package discountstrategy;

/**
 *
 * @author Mike
 */
public interface DataAccessStrategy {

    public abstract Customer findCustomer(final String customerId);
    
    public abstract Product findProduct(final String productId);
    
}
