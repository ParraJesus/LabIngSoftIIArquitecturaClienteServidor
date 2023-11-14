package edu.escuela.APIRESTAgencyTravelServer.services;

import co.unicauca.travelagency.commons.domain.Customer;
import co.unicauca.travelagency.commons.infra.JsonError;
import co.unicauca.travelagency.commons.infra.Utilities;
import edu.escuela.APIRESTAgencyTravelServer.acces.ICustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    ICustomerRepository repo;

    public CustomerService(ICustomerRepository repo) {
        this.repo = repo;
    }

    public synchronized Customer findCustomer(String id) {
        return repo.findCustomer(id);
    }

    public synchronized List<Customer> getCustomers() {
        return repo.getCustomers();
    }

    public synchronized String createCustomer(Customer customer) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (customer.getId().isEmpty() || customer.getFirstName().isEmpty()
                || customer.getLastName().isEmpty() || customer.getEmail().isEmpty()
                || customer.getGender().isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST","id, nombres, apellidos, email y género son obligatorios. "));
        }

        if (!customer.getEmail().contains("@")){
            errors.add(new JsonError("400", "BAD_REQUEST","Email debe tener una @. "));
        }

        if(!(customer.getGender().equalsIgnoreCase("M") || customer.getGender().equalsIgnoreCase("F"))){
            errors.add(new JsonError("400", "BAD_REQUEST","Sexo debo ser M o F. "));
        }

        if(!Utilities.isNumeric(customer.getMobile())){
            errors.add(new JsonError("400", "BAD_REQUEST","Teléfono móvil debe contener sólo dígitos "));

        }
        // Que no esté repetido

        Customer customerSearched = this.findCustomer(customer.getId());
        if (customerSearched != null){
            errors.add(new JsonError("400", "BAD_REQUEST","La cédula ya existe. "));
        }

        return repo.createCustomer(customer);
    }

    public String updateUser(Customer customer) {
        return repo.updateUser(customer);
    }

    public String updateName(String id,String name){
        return repo.updateName(id,name);
    }

}
