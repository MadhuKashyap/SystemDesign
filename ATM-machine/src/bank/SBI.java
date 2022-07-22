package bank;

import card.Card;

public class SBI extends Bank{
    public SBI(String atmNo, int pin)
    {
        super(atmNo, pin);
    }
    public Card card()
    {
        return new Card("SBI", atmNo, pin);
    }
}
