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
        if(name == null || name.length() == 0 || name.length() < 2){
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }
    
    
}
