import billCalc.BillCalculation;
import customer.Customer;
import deliveryApp.DeliveryApp;
import order.Order;

public class Main {
    public static void main(String[] args) {
        Customer cust = new Customer();
        cust.setName("mannu");
        cust.setPincode(827009);
        Order order =new Order(cust, 1, "pizza",2);
        BillCalculation b = new BillCalculation(order);
        b.calcBill();
        DeliveryApp d = new DeliveryApp(order);
        d.deliverOrder();
    }
}
