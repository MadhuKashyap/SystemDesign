package billCalc;

import order.Order;

import java.util.Random;

public class BillCalculation {
    Order order;
    public BillCalculation(Order order)
    {
        this.order = order;
    }
    public void calcBill()
    {
        Random rand = new Random();
        double totalAmt = rand.nextInt(200) * this.order.getQty(); //using random function to generate price of item x
        order.setBill(totalAmt);
    }
}
