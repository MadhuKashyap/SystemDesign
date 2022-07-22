package bank;

import card.Card;

public class PNB extends Bank{
    public PNB(String atmNo, int pin)
    {
        super(atmNo, pin);
    }
    public Card card()
    {
        return new Card("PNB", atmNo, pin);
    }
}
