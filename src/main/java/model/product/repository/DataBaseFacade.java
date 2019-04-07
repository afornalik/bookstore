package model.product.repository;

import model.Product;

import java.util.Collection;
import java.util.List;

public interface DataBaseFacade {

    Product getProduct(long id);

    List<? extends Product> getAllProduct();

    void addProduct(Product product);

    void addManyProduct(Collection<Product> products);

    void update(Product updaProduct);

    void removeProduct(Product product);
}
