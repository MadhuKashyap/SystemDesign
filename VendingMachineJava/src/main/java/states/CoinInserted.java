package main.java.states;

import main.java.exception.InSufficientBalanceException;
import main.java.exception.InSufficientCountException;
import main.java.exception.InvalidCoinException;
import main.java.inventory.Product;
import main.java.vending.VendingMachine;

public class CoinInserted implements State
{
    VendingMachine vendingMachine;
    CoinInserted()
    {
        vendingMachine = new VendingMachine();
    }
    public void check_state()
    {
        if(!(vendingMachine.getState() instanceof CoinInserted))
            throw new IllegalStateException("It is not in CoinInserted State");
    }
    public void insertCoin(double amt) throws InvalidCoinException {
        if(amt == 1 || amt == 5 || amt == 10 || amt == 25)
            vendingMachine.setAmount(vendingMachine.getAmount()+amt);
        else
            throw new InvalidCoinException("Coin denomination Not accepted");
    }
    public void selectProduct(Product p) throws InSufficientBalanceException, InSufficientCountException {
        if(p.getPrice() > vendingMachine.getAmount())
            throw new InSufficientBalanceException("Price of product is more than inserted coin sum");
        else if(p.getCount() < 0)
            throw new InSufficientCountException("Product is not availabe");
        vendingMachine.setState(new Dispense());

    }
    public void dispense(Product p)
    {

    }
}
