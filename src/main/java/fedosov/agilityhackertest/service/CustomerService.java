package fedosov.agilityhackertest.service;

import fedosov.agilityhackertest.model.Customer;
import fedosov.agilityhackertest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomerService {

    @Autowired
    CustomerRepository customers;


    public Iterable<Customer> findCustomers() {
        return customers.findAll();
    }

    public Customer findCustomer(Integer id) {
        return customers.findOne(id);
    }

    public void createOrUpdateCustomer(Customer customer) {
        customers.save(customer);
    }

    private final Random amount = new Random();

    public Customer generateCustomer() {
        Customer customer = new Customer();
        customer.setName("Jack" + amount.nextInt());
        customer.setSurName("Snow" + amount.nextInt());
        return customer;
    }


}