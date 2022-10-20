package furkan.storeApp.services;

import furkan.storeApp.entity.Product;
import furkan.storeApp.person.User;

import java.util.List;

public interface ProductService<P extends Product> {
    void addProduct(List<P> productList, P product, User user);

    void deleteProduct(List<P> productList, P product, User user);

    List<P> getProductList();

}
