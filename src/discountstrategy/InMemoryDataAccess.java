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
public class InMemoryDataAccess implements DataAccessStrategy {
    
    private Customer[] customers = {
        new Customer("100", "James Smith"),
        new Customer("101", "Mary Johnson"),
        new Customer("102", "Jason Bourne")
    };
    
    private Product[] products = {
        new Product("M101", "Men's Dress Pants", 29.99, new PercentageDiscount(.20)),
        new Product("A012", "Men's Packer T-Shirt", 19.95, new FlatRateDiscount(5.00)),
        new Product("S206", "Black Socks", 12.99, new QuantityDiscount(.05,5)),
        new Product("W456", "Leather Wallet", 14.99, new NoDiscount())
    };
    
    
    @Override
    public final Customer findCustomer(final String customerId) {
        if(customerId == null || customerId.length() == 0){
            throw new IllegalArgumentException("Sorry, cannot find customer in database");
        }
         Customer customer = null;
         for(Customer c : customers){
             if(customerId.equals(c.getCustomerId())){
                 customer = c;
                 break;
             }
         }
         return customer;
    }

    @Override
    public final Product findProduct(final String productId) {
        if(productId == null || productId.length() == 0){
            System.out.println("Sorry, cannot find product in database");
            return null;
        }
        Product product = null;
        for(Product p : products){
            if(productId.equals(p.getProductId())){
                product = p;
                break;
            }
        }
        return product;
    }    
}
