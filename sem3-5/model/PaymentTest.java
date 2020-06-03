package model;

import integration.Item;
import integration.ItemData;
import org.junit.Test;
import util.Amount;

import static org.junit.Assert.*;

public class PaymentTest {

    @Test
    public void testGetChange() {
        Amount price = new Amount(20);
        Amount tax = new Amount(5);
        String itemNameAndIdentifier = "Peach";
        ItemData itemDescription = new ItemData(price, itemNameAndIdentifier, tax);
        Amount quantity = new Amount(2);
        Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
        Total total = new Total();
        total.updateTotal(item);
        Amount paidAmount = new Amount(100);
        Payment payment = new Payment(paidAmount, total);
        Amount expectedResult = paidAmount.minus(price.multiply(quantity).plus(tax.multiply(quantity)));
        Amount actualResult = payment.getChange();
        assertEquals("Change is not the same.", expectedResult, actualResult);
    }
}