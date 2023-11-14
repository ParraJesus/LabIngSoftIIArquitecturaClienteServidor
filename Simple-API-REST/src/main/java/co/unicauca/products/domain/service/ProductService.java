
package co.unicauca.products.domain.service;

import co.unicauca.products.access.IProductRepository;
import co.unicauca.products.domain.entity.Product;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import java.util.List;

@RequestScoped
public class ProductService {

    @Inject
    @Default
    IProductRepository repo;

    public ProductService() {
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(int id) {
        return repo.findById(id);
    }

    public boolean create(Product prod) {
        return repo.create(prod);
    }

    public boolean update(Product prod) {
        return repo.update(prod);
    }

    public boolean delete(int id) {
        return repo.delete(id);
    }
}
