package main.java.states;

//At any time we can have 3 different states of a vending machine
// 1. no coin inserted
// 2. coin inserted
// 3. dispensing product

import main.java.exception.InSufficientBalanceException;
import main.java.exception.InSufficientCountException;
import main.java.exception.InvalidCoinException;
import main.java.inventory.Product;

public interface State {
    public void check_state();
    public void insertCoin(double amt) throws InvalidCoinException;
    public void selectProduct(Product p)
        throws InSufficientBalanceException, InSufficientCountException;
    public void dispense(Product p);
}
