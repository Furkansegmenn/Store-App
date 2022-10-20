package furkan.storeApp.repository;

import furkan.storeApp.entity.Product;

import java.util.List;

public interface ProductRepository<P extends Product> {
    void addProduct(P product);

    void deleteProduct(int id);

    List<P> getProductList();

}
