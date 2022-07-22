package bank;

import card.Card;

public abstract class Bank {
    String atmNo;
    int pin;
    Bank(String atmNo, int pin)
    {
        this.atmNo = atmNo;
        this.pin = pin;
    }
    public abstract Card card();
}
