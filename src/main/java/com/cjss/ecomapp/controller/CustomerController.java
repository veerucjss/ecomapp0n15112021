package com.cjss.ecomapp.controller;
import com.cjss.ecomapp.error.CustomerNotFoundException;
import com.cjss.ecomapp.model.Customer;
import com.cjss.ecomapp.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {
    @Autowired
    private final CustomerRepository repository;

    CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/show-all")
    List<Customer> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/signup")
    Customer newCustomer(@RequestBody Customer newCustomer) {

        return repository.save(newCustomer);
    }

    // Single item

    @GetMapping("/view-record/{id}")
    Customer one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/update/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {


        return repository.findById(id)
                .map(customer -> {
                    customer.setFirstname(newCustomer.getFirstname());
                    customer.setLastName(newCustomer.getLastName());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setMobile(newCustomer.getMobile());
                    customer.setPassword(newCustomer.getPassword());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }
    @DeleteMapping("/delete-record/{id}")
    void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}