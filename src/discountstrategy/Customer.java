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

    public Customer(String customerId, DataAccessStrategy db) {
        setCustomerId(customerId);
    }

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public final String getCustomerId() {
        return customerId;
    }

    public final void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }
    
    
}
