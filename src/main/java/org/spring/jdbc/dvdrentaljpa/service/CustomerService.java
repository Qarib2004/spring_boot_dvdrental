package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Customer;
import org.spring.jdbc.dvdrentaljpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CustomerService {

    private static final Logger logger = Logger.getLogger(CustomerService.class.getName());

    @Autowired
    private CustomerRepository customerRepository;
    public void insert(Customer customer){
        logger.info("Insert customer: " + customer);
         customerRepository.save(customer);
    }

    public void update(Customer customer_id){
        logger.info("Update customer by id: " + customer_id);
        customerRepository.save(customer_id);
    }

    public void delete(int customer_id){
        logger.info("Delete customer by id: " + customer_id);
        customerRepository.deleteById(customer_id);
    }

    public List<Customer> getAllCustomers() {
        logger.info("Select all table: customer");
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(int customer_id) {
        logger.info("Select customer by id: " + customer_id);
        return customerRepository.findById(customer_id);
    }
}

