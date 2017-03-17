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
class Customer {
    private String customerId;
    private String name;

    public Customer(final String customerId, final DataAccessStrategy db) {
        setCustomerId(customerId);
        
    }

    public Customer(final String customerId, final String name) {
        setCustomerId(customerId);
        setName(name);
    }

    public final String getCustomerId() {
        return customerId;
    }

    public final void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }
    
    
}
