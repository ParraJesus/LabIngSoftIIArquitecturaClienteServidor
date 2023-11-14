
package co.unicauca.products.presentation.rest;

import co.unicauca.products.domain.service.ProductService;
import co.unicauca.products.domain.entity.Product;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("productos")
public class ProductController {

    @Inject
    private ProductService service;

    public ProductController() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> findAll() {
        return service.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Product findById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String create(Product prod) {
        if (service.create(prod)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Producto creado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo crear el producto\",\"errores\":\"Id ya existe\"}";
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String update(Product prod) {
        if (service.update(prod)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Producto modificado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo modificar el producto\",\"errores\":\"Id no existe\"}";
        }
    }

    @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") Integer id) {
        if (service.delete(id)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Producto borrado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo borrar el producto\",\"errores\":\"Id no existe\"}";
        }
    }
}
