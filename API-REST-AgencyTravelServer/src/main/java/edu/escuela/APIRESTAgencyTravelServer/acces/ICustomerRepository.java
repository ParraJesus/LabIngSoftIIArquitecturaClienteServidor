package edu.escuela.APIRESTAgencyTravelServer.acces;

import co.unicauca.travelagency.commons.domain.Customer;
import java.util.List;

public interface ICustomerRepository {

    public Customer findCustomer(String id);
    public List<Customer> getCustomers();
    public String createCustomer(Customer customer);
    public String updateUser(Customer customer);
    public String updateName(String id,String name);

}
