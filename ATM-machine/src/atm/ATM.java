package atm;

import card.Card;

public class ATM {
    Card card;
    public ATM(Card card) {
        this.card = card;
    }
    public double checkBalance() {
        return card.getBalance();
    }
    public boolean withdraw(Double amt)
    {
        if(card.getBalance() < amt) {
            System.out.println("Insufficient balance, cant withdraw");
            return false;
        }
        double  amount= card.getBalance();
        amount -= amt;
        card.setBalance(amount);
        return true;
    }

    @Override public String toString() {
        return "ATM{" + "card=" + card + '}';
    }
}
