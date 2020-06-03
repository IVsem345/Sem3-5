package integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Amount;

import static org.junit.Assert.*;

class ItemDataTest {
    private ItemData itemToTest;

    @BeforeEach
    void setUp() {
        this.itemToTest = new ItemData(new Amount(20), "Peach", new Amount(5));
    }

    @AfterEach
    void tearDown() {
        this.itemToTest = null;
    }

    @Test
    void testToString() {
        Amount price = new Amount(10);
        Amount tax = new Amount(5);
        String itemName = "Tomat";
        ItemData ItemData = new ItemData(price, itemName, tax);
        String expectedString = "item name: " + itemName + "\t" + "price: " + price + "\t" + "tax amount: " + tax + "\t";
        String resultString = ItemData.toString();
        assertEquals("ItemData String is not the same as other String with same content.", expectedString, resultString);
    }

    @Test
    void testToStringWithEmptyItemNameAndZeroAmounts() {
        Amount price = new Amount(0);
        Amount tax = new Amount(0);
        String itemName = "";
        ItemData ItemData = new ItemData(price, itemName, tax);
        String expectedString = "item name: " + itemName + "\t" + "price: " + price + "\t" + "tax amount: " + tax + "\t";
        String resultString = ItemData.toString();
        assertEquals("ItemData String is not the same as other String with same content.", expectedString, resultString);
    }

    @Test
    void testToStringWithEmptyItemNameAndMaximumAndMinimum() {
        Amount price = new Amount(Integer.MAX_VALUE);
        Amount tax = new Amount(Integer.MIN_VALUE);
        String itemName = "";
        ItemData ItemData = new ItemData(price, itemName, tax);
        String expectedString = "item name: " + itemName + "\t" + "price: " + price + "\t" + "tax amount: " + tax + "\t";
        String resultString = ItemData.toString();
        assertEquals("ItemData String is not the same as other String with same content.", expectedString, resultString);
    }

    @Test
    void testToStringNotEqualStrings() {
        Amount price = new Amount(10);
        Amount tax = new Amount(5);
        String itemName = "Corn";
        ItemData ItemData = new ItemData(price, itemName, tax);
        String expectedString = "item nme: " + itemName + "\t" + "prie: " + price + "\t" + "tx amunt: " + tax + "\t";
        String resultString = ItemData.toString();
        assertNotEquals("ItemData String is not the same as other String with same content.", expectedString, resultString);
    }

    @Test
    void testEquals() {
        Amount price = new Amount(20);
        Amount tax = new Amount(5);
        String itemName = "Peach";
        ItemData otherItemData = new ItemData(price, itemName, tax);
        boolean expectedResult = true;
        boolean result = itemToTest.equals(otherItemData);
        assertEquals("ItemDTOs instances with the same state are not equal.", expectedResult, result);
    }

    @Test
    void testNotEquals() {
        Amount price = new Amount(10);
        Amount tax = new Amount(2);
        String itemName = "Orange";
        ItemData otherItemData = new ItemData(price, itemName, tax);
        boolean expectedResult = false;
        boolean result = itemToTest.equals(otherItemData);
        assertEquals("ItemData instances with the different state are equal.", expectedResult, result);
    }

    @Test
    void testEqualsJavaObject() {
        Object otherObject = new Object();
        boolean expectedResult = false;
        boolean result = itemToTest.equals(otherObject);
        assertEquals("ItemData instance equal to java.lang.Object.", expectedResult, result);
    }

    @Test
    void testEqualsNull() {
        Object otherObject = null;
        boolean expectedResult = false;
        boolean result = itemToTest.equals(otherObject);
        assertEquals("ItemData instance equal to null", expectedResult, result);
    }


}