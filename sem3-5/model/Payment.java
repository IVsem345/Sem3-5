package model;

import util.Amount;

/**
 *  Represents a payment of a specific sale.
 */
public class Payment {
    private Amount paidAmount;
    private Total total;

    /**
     * Creates a new instance, represented as a payment.
     *
     * @param paidAmount The amount money the customer have given.
     * @param total The total that will that will be payed for by the customer.
     */
    public Payment(Amount paidAmount, Total total){
        this.paidAmount = paidAmount;
        this.total = total;
    }

    /**
     * Get the total cost of the payment.
     *
     * @return The total cost.
     */
    Total getTotal() {
        return total;
    }

    /**
     *  Calculates the amount of change and returns it as an {@link Amount}
     *
     * @return The total change as {@link Amount}
     */
    public Amount getChange(){
        return paidAmount.minus(total.getTotalWithTax());
    }



}
