package edu.escuela.APIRESTAgencyTravelServer.acces;

import co.unicauca.travelagency.commons.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public final class CustomerRepositoryImplArrays implements ICustomerRepository {

    private static List<Customer> customers;

    public CustomerRepositoryImplArrays() {
        if (customers == null){
            customers = new ArrayList();
        }

        if (customers.size() == 0){
            inicializar();
        }
    }

    public void inicializar() {
        customers.add(new Customer("98000001", "Andrea", "Sanchez", "Calle 14 No 11-12 Popayan", "3145878752", "andrea@hotmail.com", "Femenino"));
        customers.add(new Customer("98000002", "Libardo", "Pantoja", "Santa Barbar Popayan", "3141257845", "libardo@gmail.com", "Masculino"));
        customers.add(new Customer("98000003", "Carlos", "Pantoja", "Santa Barbar Popayan", "3141257846", "carlos@gmail.com", "Masculino"));
        customers.add(new Customer("98000004", "Fernanda", "Arevalo", "Calle 16 No 12-12 Popayan", "3154562133", "fercha@hotmail.com", "Femenino"));
        customers.add(new Customer("98000005", "Manuel", "Perez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer("98000006", "Alejandro", "Mosquera", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer("98000007", "Cesar", "Gutierres Sanchez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer("98000008", "Julio", "Bravo Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer("98000009", "Alberto", "Mendez Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer("98000010", "Alexander", "Ponce Yepes", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));

    }
    @Override
    public Customer findCustomer(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public String createCustomer(Customer customer) {
        customers.add(customer);
        return customer.getId();
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String updateUser(Customer customer) {
        for(Customer cus:customers){
            if(cus.getId().equals(customer.getId())){
                cus.setAddress(customer.getAddress());
                cus.setEmail(customer.getEmail());
                cus.setFirstName(customer.getFirstName());
                cus.setGender(customer.getGender());
                cus.setId(customer.getId());
                cus.setLastName(customer.getLastName());
                cus.setMobile(customer.getMobile());
                return cus.toString();
            }
        }
        return null;
    }

    @Override
    public String updateName(String id, String name) {
        for(Customer cus:customers){
            if(cus.getId().equals(id)){
                cus.setFirstName(name);
                return cus.toString();
            }
        }
        return null;

    }

}
