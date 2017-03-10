/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Mike
 */
public interface DataAccessStrategy {

    public abstract Customer findCustomer(String customerId);
    
    public abstract Product findProduct(String productId);
    
}
