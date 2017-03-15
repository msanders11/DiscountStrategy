package discountstrategy;

/**
 *
 * @author Mike
 */
public class LineItem {

    private Product product;
    private int qty;

    public LineItem(String productId, int qty, DataAccessStrategy db) {
        product = findProduct(productId, db);
        setQty(qty);
    }

    private Product findProduct(String productId, DataAccessStrategy db) {
        if (productId == null || productId.length() == 0) {
            throw new IllegalArgumentException("Invalid product ID.");
        }
        if (db == null) {
            throw new IllegalArgumentException("No Data Access Strategy.");
        }
        return db.findProduct(productId);
    }

    public final String getLineItemData() {
        String data = "";
        data += product.getProductId() + "   ";
        data += product.getName() + "   ";
        data += product.getRetailPrice() + "   ";
        data += qty + "      ";
        data += getSubtotal() + "       ";
        data += String.format("%,.2f",product.getDiscountStrategy().getDiscount(product.getRetailPrice(), qty));
        return data;
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        if(product == null){
            throw new IllegalArgumentException("No product entered.");
        }
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        if(qty <= 0){
            throw new IllegalArgumentException("Invalid quantity");
        }
        this.qty = qty;
    }

    public final double getSubtotal() {
        return product.getRetailPrice() * qty;
    }
}
