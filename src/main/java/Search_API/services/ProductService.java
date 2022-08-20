package Search_API.services;

import java.util.List;

import Search_API.entity.Product;

public interface ProductService {
	
	List<Product> searchProducts(String query);

	Product createProduct(Product product);
	
	Integer deleteProductByName (String name);

}
