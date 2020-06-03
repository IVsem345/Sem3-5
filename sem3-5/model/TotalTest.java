package model;

import integration.Item;
import integration.ItemData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Amount;

import static org.junit.Assert.*;

public class TotalTest {
    private Total totalWithZero;

    @Before
    public void setUp() throws Exception {
        totalWithZero = new Total();
    }

    @After
    public void tearDown() throws Exception {
        totalWithZero = null;
    }

    @Test
    public void getTotalWithTax() {
        String itemNameAndItemIdentifier = "Peach";
        Amount price = new Amount(20);
        Amount tax = new Amount(5);
        Amount quantity = new Amount(1);
        ItemData itemDescription = new ItemData(price, itemNameAndItemIdentifier, tax);
        Item item = new Item(itemDescription, itemNameAndItemIdentifier, quantity);

        Amount expectedTotalWithTax = price.plus(tax);

        totalWithZero.updateTotal(item);
        Amount resultTotalWithTax = totalWithZero.getTotalWithTax();

        assertEquals("The total with tax is not the same as identical amount.", expectedTotalWithTax, resultTotalWithTax);

    }

    @Test
    public void updateTotal() {
        String itemNameAndItemIdentifier = "Peach";
        Amount price = new Amount(20);
        Amount tax = new Amount(5);
        Amount quantity = new Amount(4);
        ItemData itemDescription = new ItemData(price, itemNameAndItemIdentifier, tax);
        Item item = new Item(itemDescription, itemNameAndItemIdentifier, quantity);

        Amount expectedTotal = price.multiply(quantity);
        Amount expectedTax = tax.multiply(quantity);

        totalWithZero.updateTotal(item);
        Amount resultTotal = totalWithZero.getTotal();
        Amount resultTax = totalWithZero.getTotalTax();

        assertEquals("Total amount not equal to identical amount.", expectedTotal, resultTotal);
        assertEquals("Tax amount not equal to identical amount.", expectedTax, resultTax);
    }

    @Test
    public void updateTotalWithNullItem() {
        String itemNameAndItemIdentifier = "Peach";
        Amount price = new Amount(20);
        Amount tax = new Amount(5);
        Amount quantity = new Amount(4);
        ItemData itemDescription = new ItemData(price, itemNameAndItemIdentifier, tax);
        Item item = null;

        Amount expectedTotal = price.multiply(quantity);
        Amount expectedTax = tax.multiply(quantity);

        totalWithZero.updateTotal(item);
        Amount resultTotal = totalWithZero.getTotal();
        Amount resultTax = totalWithZero.getTotalTax();

        assertNotEquals("Total amount equal to null object.", expectedTotal, resultTotal);
        assertNotEquals("Tax amount equal to null object.", expectedTax, resultTax);
    }
}