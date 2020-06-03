package integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Amount;

import static org.junit.Assert.*;

class ItemTest {
    private Item itemWithPeach;

    @BeforeEach
    void setUp() {
        String itemNameAndIdentifier = "Peach";
        itemWithPeach = new Item(new ItemData(new Amount(10), itemNameAndIdentifier, new Amount(2)), itemNameAndIdentifier, new Amount(10));
    }

    @AfterEach
    void tearDown() {
    	itemWithPeach = null;
    }

    @Test
    void testIncreaseQuantity() {
        Amount summand1 = new Amount(10);
        Amount summand2 = new Amount(5);
        Amount expectedAmount = summand1.plus(summand2);
        itemWithPeach.increaseQuantity(summand2);
        Amount resultAmount = itemWithPeach.getQuantity();
        assertEquals("The increased amount in the Item instance is not the same as the arithmetic of class Amount", expectedAmount, resultAmount);
    }

    @Test
    void testIncreaseQuantityWithNegativeSummand() {
        Amount summand1 = new Amount(10);
        Amount summand2 = new Amount(-15);
        Amount expectedAmount = summand1.plus(summand2);
        itemWithPeach.increaseQuantity(summand2);
        Amount resultAmount = itemWithPeach.getQuantity();
        assertEquals("The increased amount in the Item instance is not the same as the arithmetic of class Amount", expectedAmount, resultAmount);
    }

    @Test
    void testIncreaseQuantityWithMaxValue() {
        Amount summand1 = new Amount(10);
        Amount summand2 = new Amount(Integer.MAX_VALUE);
        Amount expectedAmount = summand1.plus(summand2);
        itemWithPeach.increaseQuantity(summand2);
        Amount resultAmount = itemWithPeach.getQuantity();
        assertEquals("The increased amount in the Item instance is not the same as the arithmetic of class Amount", expectedAmount, resultAmount);
    }

    @Test
    void testDecreaseQuantity() {
        Amount minuend = new Amount(10);
        Amount subtrahend = new Amount(5);
        Amount expectedAmount = minuend.minus(subtrahend);
        itemWithPeach.decreaseQuantity(subtrahend);
        Amount resultAmount = itemWithPeach.getQuantity();
        assertEquals("The decreased amount in the Item instance is not the same as the arithmetic of class Amount", expectedAmount, resultAmount);
    }

    @Test
    void testDecreaseQuantityWithNegativeSubtrahend() {
        Amount minuend = new Amount(10);
        Amount subtrahend = new Amount(-15);
        Amount expectedAmount = minuend.minus(subtrahend);
        itemWithPeach.decreaseQuantity(subtrahend);
        Amount resultAmount = itemWithPeach.getQuantity();
        assertEquals("The decreased amount in the Item instance is not the same as the arithmetic of class Amount", expectedAmount, resultAmount);
    }

    @Test
    void testDecreaseQuantityWithMaxValue() {
        Amount minuend = new Amount(10);
        Amount subtrahend = new Amount(Integer.MAX_VALUE);
        Amount expectedAmount = minuend.minus(subtrahend);
        itemWithPeach.decreaseQuantity(subtrahend);
        Amount resultAmount = itemWithPeach.getQuantity();
        assertEquals("The decreased amount in the Item instance is not the same as the arithmetic of class Amount", expectedAmount, resultAmount);
    }

    @Test
    void testToString() {
        Amount price = new Amount(10);
        Amount tax = new Amount(2);
        String itemName = "Peach";
        ItemData itemDTO = new ItemData(price, itemName, tax);
        Amount quantity = new Amount(10);
        Item itemToTest = new Item(itemDTO, itemName, quantity);
        String expectedString = "item identifier: " + itemName + "quantity: " + quantity + "item description: " + itemDTO.toString();
        String resultString = itemToTest.toString();
        assertEquals("Strings with the same state are not equal.", expectedString, resultString);
    }

    @Test
    void testToStringNotTheSameString() {
        Amount price = new Amount(10);
        Amount tax = new Amount(2);
        String itemName = "Peach";
        ItemData ItemData = new ItemData(price, itemName, tax);
        Amount quantity = new Amount(10);
        Item itemToTest = new Item(ItemData, itemName, quantity);
        String expectedString = "identifier: " + itemName + "quantity: " + quantity + "Item description: " + ItemData.toString();
        String resultString = itemToTest.toString();
        assertNotEquals("Strings with different state are equal.", expectedString, resultString);
    }

    @Test
    void testToStringWithEmptyStrings() {
        Amount price = new Amount(0);
        Amount tax = new Amount(0);
        String itemName = "";
        ItemData itemDTO = new ItemData(price, itemName, tax);
        Amount quantity = new Amount(0);
        Item itemToTest = new Item(itemDTO, itemName, quantity);
        String expectedString = "";
        String resultString = itemToTest.toString();
        assertNotEquals("Strings with different state are equal.", expectedString, resultString);
    }

    @Test
    void testEquals() {
        Amount price = new Amount(10);
        Amount tax = new Amount(2);
        String itemName = "Peach";
        ItemData otherItemData = new ItemData(price, itemName, tax);
        Amount quantity = new Amount(10);
        Item itemToTest = new Item(otherItemData, itemName, quantity);
        boolean expectedResult = true;
        boolean actualResult = itemWithPeach.equals(itemToTest);
        assertEquals("Two Item instances with the same state are not equal.", expectedResult, actualResult);
    }

    @Test
    void testEqualsNotEqual() {
        Amount price = new Amount(9);
        Amount tax = new Amount(1);
        String itemName = "Corn";
        ItemData otherItemData = new ItemData(price, itemName, tax);
        Amount quantity = new Amount(0);
        Item itemToTest = new Item(otherItemData, itemName, quantity);
        boolean expectedResult = false;
        boolean actualResult = itemWithPeach.equals(itemToTest);
        assertEquals("Two Item instances with different state are equal.", expectedResult, actualResult);
    }

    @Test
    void testEqualsNull() {
        Item itemToTest = null;
        boolean expectedResult = false;
        boolean actualResult = itemWithPeach.equals(itemToTest);
        assertEquals("Item Instance is equal to null.", expectedResult, actualResult);
    }

    @Test
    void testEqualsJavaObject() {
        Object object = new Object();
        boolean expectedResult = false;
        boolean actualResult = itemWithPeach.equals(object);
        assertEquals("Item Instance is equal to java.lang.Object.", expectedResult, actualResult);
    }

    @Test
    void testEqualsNotTheSameIdentifier() {
        Amount price = new Amount(10);
        Amount tax = new Amount(2);
        String itemName = "Peach";
        ItemData otherItemData = new ItemData(price, itemName, tax);
        Amount quantity = new Amount(10);
        Item itemToTest = new Item(otherItemData, "test", quantity);
        boolean expectedResult = false;
        boolean actualResult = itemWithPeach.equals(itemToTest);
        assertEquals("Two Item instances with different item identifiers are equal.", expectedResult, actualResult);
    }
}