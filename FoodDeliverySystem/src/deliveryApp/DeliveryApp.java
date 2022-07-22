package deliveryApp;

import order.Order;

public class DeliveryApp {
    Order order;
    public DeliveryApp(Order order)
    {
        this.order = order;
    }
    public void deliverOrder()
    {
        System.out.println("Currently delivering order of " + order.getFoodItem() + "ordered by "+ order.getCust().getName());
    }
}
