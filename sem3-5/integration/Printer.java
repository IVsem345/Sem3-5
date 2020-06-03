package integration;

import model.Receipt;

/**
 * Represents a printer.
 */
public class Printer {

    /**
     * Creates an instance, represented as a printer.
     */
    public Printer(){ }

    /**
     * Prints the specified receipt, this is a dummy printer and not a real one.
     * It prints to <code>System.out</code>, instead of a printer.
     *
     * @param receipt The specified receipt that will be printed.
     */
    public void printReceipt(Receipt receipt){
        System.out.println(receipt.toString());
    }
}
