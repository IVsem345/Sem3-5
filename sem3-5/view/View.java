package view;

import controller.Controller;
import util.Amount;

/**
 * This application does not have an "actual" view.
 * This class is a placeholder for a view that can make a sample execution
 */
public class View {
    private Controller controller;

    /**
     *  Creates a new instance, represented as a view.
     * @param controller The class where all calls are being made.
     */
    public View(Controller controller){
        this.controller = controller;
    }

    /**
     *  Makes a sample execution of the application.
     *  AKA, simulating someone making inputs to the application.
     */
    public void sampleExecution(){
        System.out.println("Cashier starts new sale.\n");
        controller.startNewSale();
        System.out.println("Cashier enter items. \n");
        String out = controller.registerItem("Corn", new Amount(1));
        System.out.println(out);
        out = controller.registerItem("Cherry", new Amount(4));
        System.out.println(out);
        out = controller.registerItem("Corn", new Amount(5));
        System.out.println(out);
        out = controller.registerItem("Orange", new Amount(20));
        System.out.println(out);
        out = controller.registerItem("Peach", new Amount(2));
        System.out.println(out);
        System.out.println("Cashier displays the total with taxes. \n");
        out = controller.displayTotalWithTax();
        System.out.println(out);
        System.out.println("Cashier enters the paid amount. \n");
        out = controller.pay(new Amount(2000));
        System.out.println(out);
    }
}

