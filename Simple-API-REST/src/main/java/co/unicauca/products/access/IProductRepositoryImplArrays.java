
package co.unicauca.products.access;

import co.unicauca.products.domain.entity.Product;
import jakarta.enterprise.inject.Default;
import java.util.ArrayList;
import java.util.List;

@Default
public class IProductRepositoryImplArrays implements IProductRepository {

    public static List<Product> products;

    public IProductRepositoryImplArrays() {
        if (products == null) {
            products = new ArrayList<>();
            initialize();
        }
    }

    private void initialize() {
        products.add(new Product(1, "Tv samsung", 200000d));
        products.add(new Product(2, "Tv lg", 300000d));
        products.add(new Product(1, "Tablet asus RESD-TD-34", 400000d));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer id) {
        for (Product prod : products) {
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean create(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            //Ya existe
            return false;
        }
        products.add(newProduct);
        return true;
    }

    @Override
    public boolean update(Product product) {
        Product prod = this.findById(product.getId());
        if (prod != null) {
            prod.setName(product.getName());
            prod.setPrice(product.getPrice());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        int i = 0;
        for (Product prod : products) {
            if (prod.getId() == id) {
                products.remove(i++);
                return true;
            }
        }
        return false;
    }
}
