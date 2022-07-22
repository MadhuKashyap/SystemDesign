package card;

public class Card {
    String atmNo, bank;
    int pin;
    Double balance;
    public Card(String bank, String atmoNo, int pin)
    {
        this.bank = bank;
        this.balance = 100.0;
        this.atmNo = atmoNo;
        this.pin = pin;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getBank() {
        return bank;
    }

    @Override public String toString() {
        return "Card{" + "atmNo='" + atmNo + '\'' + ", bank='" + bank + '\'' + ", pin=" + pin
            + ", balance=" + balance + '}';
    }
}
