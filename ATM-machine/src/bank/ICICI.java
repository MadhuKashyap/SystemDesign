package bank;

import card.Card;

public class ICICI extends Bank{
    public ICICI(String atmNo, int pin)
    {
        super(atmNo, pin);
    }
    public Card card()
    {
        return new Card("ICICI", atmNo, pin);
    }
}
