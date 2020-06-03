package model;

import integration.Item;
import integration.ItemData;
import org.junit.Test;
import util.Amount;

import static org.junit.Assert.*;

public class SaleTest {

    @Test
    public void testUpdateSale() {
        Amount price = new Amount(20);
        Amount tax = new Amount(5);
        String itemNameAndIdentifier = "Peach";
        ItemData itemDescription = new ItemData(price, itemNameAndIdentifier, tax);
        Amount quantity = new Amount(2);
        Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
        Sale sale = new Sale();
        String actualResult = sale.updateSale(item);
        String expectedResult = item.getItemDescription().toString();
        assertEquals("The Strings are not equal.", expectedResult, actualResult);
    }


    @Test
    public void tesToString() {
        Amount price = new Amount(20);
        Amount tax = new Amount(5);
        String itemNameAndIdentifier = "Peach";
        ItemData itemDescription = new ItemData(price, itemNameAndIdentifier, tax);
        Amount quantity = new Amount(1);
        Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
        Sale sale = new Sale();
        sale.updateSale(item);
        String expectedResult = "item name: " + itemNameAndIdentifier + "\t" +
                "price: " + price + "\t" +
                "tax amount: " + tax + "\t" +
                " quantity: " + quantity + "\nTotal: " + price + "\nTax: " + tax + "\n";
        String actualResult = sale.toString();
        assertEquals("Strings with the same entries not the same.", expectedResult, actualResult);
    }
}