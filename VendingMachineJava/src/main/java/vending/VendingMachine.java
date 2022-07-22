package main.java.vending;

import main.java.states.NoCoinInserted;
import main.java.states.State;

public class VendingMachine {
    double amount ;
    State state;
    public VendingMachine()
    {
        amount = 0.0;
        state = new NoCoinInserted();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }



}
