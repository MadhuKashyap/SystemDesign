package main.java.states;

import main.java.exception.InvalidCoinException;
import main.java.inventory.Product;
import main.java.vending.VendingMachine;

public class NoCoinInserted implements State{
    VendingMachine vendingMachine;
    public NoCoinInserted( )
    {
        vendingMachine = new VendingMachine();
    }
    public void check_state()
    {
        if(!(vendingMachine.getState() instanceof CoinInserted))
            throw new IllegalStateException("It is not in CoinInserted State");
    }
    public void insertCoin(double amt) throws InvalidCoinException {
        //Now change the state of the vending machine to Coin inserted state
        if(amt == 1 || amt == 5 || amt == 10 || amt == 25) {
            vendingMachine.setAmount(amt);
            vendingMachine.setState(new CoinInserted());
        }
        else
            throw new InvalidCoinException("Coin denomination Not accepted");
    }
    public void selectProduct(Product p)
    {
        throw new IllegalArgumentException("No coin inserted");   // you cant select product in no coin inserted state
    }
    public void dispense(Product p)
    {
        throw new IllegalArgumentException("No coin inserted");   //product cant be dispensed in no coin inserted state
    }
}
