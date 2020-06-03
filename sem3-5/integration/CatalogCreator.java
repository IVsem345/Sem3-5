package integration;

/**
 * Represents a creator that consists of different catalogs.
 */
public class CatalogCreator {
    private DiscountCatalog discountCatalog;
    private ItemCatalog itemCatalog;

    /**
     * Creates a new instance
     */
    public CatalogCreator(){
        discountCatalog = new DiscountCatalog();
        itemCatalog = new ItemCatalog();
    }

    /**
     * Gets the value of discountCatalog.
     *
     * @return The value discountCatalog.
     */
    public DiscountCatalog getDiscountCatalog() {
        return discountCatalog;
    }

    /**
     * Gets the value of itemCatalog.
     * @return  The value of itemCatalog.
     */
    public ItemCatalog getItemCatalog() {
        return itemCatalog;
    }
}
