import atm.ATM;
import user.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("SBI", "12345678", 1234);
        System.out.println(user.issueCard());
        ATM atmCard = user.atmCardForUser();
        System.out.println(atmCard);
        System.out.println("Balance For user " +user.getAtmNo()+ " is " + atmCard.checkBalance() + "for bank " +user.issueCard().getBank());
        atmCard.withdraw(10.0);
        System.out.println(atmCard.checkBalance());
    }
}
