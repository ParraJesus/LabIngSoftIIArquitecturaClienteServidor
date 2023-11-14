package co.unicauca.products.access;

import co.unicauca.products.domain.entity.Product;
import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    Product findById(Integer id);

    boolean create(Product newProduct);

    boolean update(Product newProduct);

    boolean delete(Integer id);
}
