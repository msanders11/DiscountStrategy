package discountstrategy;

/**
 *
 * @author Mike
 */
public class LineItem {
    private Product product;
    private int qty;

    public LineItem(final String productId, final int qty, final DataAccessStrategy db) {
        product = findProduct(productId, db);
        setQty(qty);
    }

    private final Product findProduct(final String productId, final DataAccessStrategy db) {
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

    public final void setProduct(final Product product) {
        if(product == null){
            throw new IllegalArgumentException("No product entered.");
        }
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(final int qty) {
        if(qty <= 0){
            throw new IllegalArgumentException("Invalid quantity");
        }
        this.qty = qty;
    }

    public final double getSubtotal() {
        return product.getRetailPrice() * qty;
    }
}
