package edu.escuela.APIRESTAgencyTravelServer.controller;

import co.unicauca.travelagency.commons.domain.Customer;
import edu.escuela.APIRESTAgencyTravelServer.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class CustomerController {
    @Autowired
    private CustomerService customService;

    @GetMapping
    public List<Customer> getCustomers(){
        return customService.getCustomers();
    }
    @GetMapping("/{id}")
    public Customer findCustomer(@PathVariable String id){
        return customService.findCustomer(id);
    }
    @PostMapping
    public String createCustomer(@RequestBody Customer newCustomer){
        return customService.createCustomer(newCustomer);
    }
    @PutMapping
    public String updateUser(@RequestBody Customer customerMod){
        return customService.updateUser(customerMod);
    }
}
