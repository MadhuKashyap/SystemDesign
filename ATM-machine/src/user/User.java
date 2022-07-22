package user;

import atm.ATM;
import bank.ICICI;
import bank.PNB;
import bank.SBI;
import card.Card;

public class User {
    String bank,atmNo;
    int pin;
    Card card;
    public User(String bank, String atmNo, int pin)
    {
        this.bank = bank;
        this.atmNo = atmNo;
        this.pin = pin;
    }
    public Card issueCard()
    {
        if(bank == "SBI")
            card = new SBI(atmNo, pin).card();
        else if(bank == "ICICI")
            card = new ICICI(atmNo, pin).card();
        else if(bank == "PNB")
            card = new PNB(atmNo, pin).card();
        return card;
    }

    public String getAtmNo() {
        return atmNo;
    }

    public ATM atmCardForUser()
    {
        ATM atm = new ATM(card);
        return atm;
    }
}
