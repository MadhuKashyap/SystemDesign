package order;

import customer.Customer;

public class Order {
    Customer cust;
    int orderId;
    String foodItem;
    int qty;
    double bill;

    public Order(Customer cust, int orderId, String foodItem, int qty) {
        this.cust = cust;
        this.orderId = orderId;
        this.foodItem = foodItem;
        this.qty = qty;
        //this.bill = bill;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public void prepareOrder()
    {
        System.out.println("Order of" + foodItem+"is bieng prepared for customer "+ cust.getName());
    }
}
