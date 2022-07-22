package main.java.states;

import jdk.swing.interop.SwingInterOpUtils;
import main.java.inventory.Product;
import main.java.vending.VendingMachine;

public class Dispense implements State{
    VendingMachine vendingMachine;
    Dispense()
    {
        vendingMachine = new VendingMachine();
    }
    public void check_state()
    {
        if(!(vendingMachine.getState() instanceof Dispense))
            throw new IllegalStateException("It is not in Dispensed State");
    }

    public void insertCoin(double amt)
    {
        System.out.println("Wait for the next transaction to insert coin");
    }
    public void selectProduct(Product p)
    {
        System.out.println("Wait for the next transaction current one is going on");
    }
    public void dispense(Product p)
    {
        double amt = vendingMachine.getAmount();
        amt -= p.getPrice();
        int cnt = p.getCount();
        cnt -= 1;
        p.setCount(cnt);
        System.out.println("You have successfully purchased " + p.getName() + "worth of rupees " + p.getPrice());
        if(amt > 0)
            System.out.println("Refund of "+ amt + "is being processed");
    }
}
