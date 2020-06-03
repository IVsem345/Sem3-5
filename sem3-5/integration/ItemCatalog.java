package integration;

import util.Amount;

import java.util.HashMap;

/**
 * Represents a dummy item database.
 */
public class ItemCatalog {
    private HashMap<String, ItemData> itemList = new HashMap<>();

    /**
     *  Creates a instance of a dummy item database.
     */
    ItemCatalog(){
        addItems();
    }

    /**
     *  Checks if the searched itemIdentifier exists in the database.
     *
     * @param itemIdentifier The looked item.
     * @return If item exists <code>true</code> else <code>false</code>
     */
    public boolean itemExists(String itemIdentifier){
        return itemList.containsKey(itemIdentifier);
    }

    /**
     * Gets the item description of the specified itemIdentifier.
     * Returns an item with the specified quantity.
     *
     * @param itemIdentifier The identifier of an item.
     * @param quantity The amount of items.
     * @return An item with it's itemDescription and quantity or null if the identifier didn't exist..
     */
    public Item getItem(String itemIdentifier, Amount quantity){
        if (itemExists(itemIdentifier)){
            return new Item(itemList.get(itemIdentifier), itemIdentifier, quantity);
        }
        return null;
    }

    private void addItems(){
        itemList.put("Corn", new ItemData(new Amount(20), "Corn", new Amount(10)));
        itemList.put("Cherry", new ItemData(new Amount(30), "Cherry", new Amount(15)));
        itemList.put("Orange", new ItemData(new Amount(42), "Orange", new Amount(20)));
        itemList.put("Peach", new ItemData(new Amount(5), "Peach", new Amount(2)));
    }
}
