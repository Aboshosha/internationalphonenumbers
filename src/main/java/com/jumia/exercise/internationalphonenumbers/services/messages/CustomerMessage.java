package com.jumia.exercise.internationalphonenumbers.services.messages;

import com.jumia.exercise.internationalphonenumbers.dataAccess.entities.Customer;

public class CustomerMessage extends Message {

    private Iterable<Customer> customers;

    public void setCustomers(Iterable<Customer> customers) {
        this.customers = customers;
    }

    public Iterable<Customer> getCustomers() {
        return customers;
    }

}
