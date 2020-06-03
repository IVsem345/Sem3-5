package util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class AmountTest {
    private Amount amountEqualToThree;

    @BeforeEach
    void setUp() {
        amountEqualToThree = new Amount(3);
    }

    @AfterEach
    void tearDown() {
        amountEqualToThree = null;
    }

    @Test
    void testEquals() {
        int otherTree = 3;
        Amount amountOtherThree = new Amount(otherTree);
        boolean expectedResult = true;
        boolean result = amountEqualToThree.equals(amountOtherThree);
        assertEquals("Amount instances with the same state are not equal", expectedResult, result);
    }

    @Test
    void testNotEquals() {
        int otherTwo = 2;
        Amount amountOtherTwo = new Amount(otherTwo);
        boolean expectedResult = false;
        boolean result = amountEqualToThree.equals(amountOtherTwo);
        assertEquals("Amount instances with the different states are equal", expectedResult, result);
    }

    @Test
    void testNotEqualsToObject() {
        Object otherObject = new Object();
        boolean expectedResult = false;
        boolean result = amountEqualToThree.equals(otherObject);
        assertEquals("Amount instance equal to java object.", expectedResult, result);
    }

    @Test
    void testNotEqualsToNull() {
        Object otherObject = null;
        boolean expectedResult = false;
        boolean result = amountEqualToThree.equals(otherObject);
        assertEquals("Amount instance equal to null.", expectedResult, result);
    }

    @Test
    void testMinus() {
        int minuend = 10;
        int subtrahend = 3;
        Amount minuendAmount = new Amount(minuend);
        Amount subtrahendAmount = new Amount(subtrahend);
        Amount expectedDifference = new Amount(minuend - subtrahend);
        Amount difference = minuendAmount.minus(subtrahendAmount);
        assertEquals("The difference is not the same.", expectedDifference, difference);
    }

    @Test
    void testMinusNegativeResult() {
        int minuend = 3;
        int subtrahend = 10;
        Amount minuendAmount = new Amount(minuend);
        Amount subtrahendAmount = new Amount(subtrahend);
        Amount expectedDifference = new Amount(minuend - subtrahend);
        Amount difference = minuendAmount.minus(subtrahendAmount);
        assertEquals("The difference is not the same.", expectedDifference, difference);
    }

    @Test
    void testMinusExpectingZeroWithNegativeOperands() {
        int minuend = -10;
        int subtrahend = -10;
        Amount minuendAmount = new Amount(minuend);
        Amount subtrahendAmount = new Amount(subtrahend);
        Amount expectedResult = new Amount(minuend - subtrahend);
        Amount difference = minuendAmount.minus(subtrahendAmount);
        assertEquals("The difference is not the same.", expectedResult, difference);
    }

    @Test
    void testPlus() {
        int summand1 = 10;
        int summand2 = 3;
        Amount summandAmount1 = new Amount(summand1);
        Amount summandAmount2 = new Amount(summand2);
        Amount expectedSum = new Amount(summand1 + summand2);
        Amount resultSum = summandAmount1.plus(summandAmount2);
        assertEquals("The sum is not the same", expectedSum, resultSum);
    }

    @Test
    void testPlusWithNegativeSum() {
        int summand1 = 3;
        int summand2 = -10;
        Amount summandAmount1 = new Amount(summand1);
        Amount summandAmount2 = new Amount(summand2);
        Amount expectedSum = new Amount(summand1 + summand2);
        Amount resultSum = summandAmount1.plus(summandAmount2);
        assertEquals("The sum is not the same", expectedSum, resultSum);
    }

    @Test
    void testPlusWithNegativeSummandExpectingSumOfZero() {
        int summand1 = 3;
        int summand2 = -3;
        Amount summandAmount1 = new Amount(summand1);
        Amount summandAmount2 = new Amount(summand2);
        Amount expectedSum = new Amount(summand1 + summand2);
        Amount resultSum = summandAmount1.plus(summandAmount2);
        assertEquals("The sum is not the same", expectedSum, resultSum);
    }

    @Test
    void testMultiply() {
        int multiplier = 10;
        int multiplicand = 3;
        Amount multiplierAmount = new Amount(multiplier);
        Amount multiplicandAmount = new Amount(multiplicand);
        Amount expectedProduct = new Amount(multiplier * multiplicand);
        Amount resultProduct = multiplierAmount.multiply(multiplicandAmount);
        assertEquals("The product is not the same", expectedProduct, resultProduct);
    }

    @Test
    void testMultiplyWithZero() {
        int multiplier = 10;
        int multiplicand = 0;
        Amount multiplierAmount = new Amount(multiplier);
        Amount multiplicandAmount = new Amount(multiplicand);
        Amount expectedProduct = new Amount(multiplier * multiplicand);
        Amount resultProduct = multiplierAmount.multiply(multiplicandAmount);
        assertEquals("The product is not the same", expectedProduct, resultProduct);
    }

    @Test
    void testMultiplyNegativeNumbers() {
        int multiplier = -10;
        int multiplicand = -3;
        Amount multiplierAmount = new Amount(multiplier);
        Amount multiplicandAmount = new Amount(multiplicand);
        Amount expectedProduct = new Amount(multiplier * multiplicand);
        Amount resultProduct = multiplierAmount.multiply(multiplicandAmount);
        assertEquals("The product is not the same", expectedProduct, resultProduct);
    }

    @Test
    void testToStringWithPositiveAmount() {
        int positiveNumber = 42;
        Amount positiveAmount = new Amount(positiveNumber);
        String expectedString = Integer.toString(positiveNumber);
        String resultString = positiveAmount.toString();
        assertEquals("The String is not the same", expectedString, resultString);
    }

    @Test
    void testToStringWithNegativeAmount() {
        int negativeNumber = -1337;
        Amount negativeAmount = new Amount(negativeNumber);
        String expectedString = Integer.toString(negativeNumber);
        String resultString = negativeAmount.toString();
        assertEquals("The String is not the same", expectedString, resultString);
    }

    @Test
    void testToStringWithZero() {
        int zeroNumber = 0;
        Amount zeroAmount = new Amount(zeroNumber);
        String expectedString = Integer.toString(zeroNumber);
        String resultString = zeroAmount.toString();
        assertEquals("The String is not the same", expectedString, resultString);
    }

}