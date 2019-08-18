package models;

public class User {
    Customer customer;

    User() {
        this.customer = new Customer("email", "name", "address");
    }

    Customer getCustomer() {
        return this.customer;
    }
}
