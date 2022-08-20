package Search_API.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Search_API.entity.Product;
import Search_API.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	//ProductRepository instance
	private ProductRepository productRepository;
	 
	//Constructor based dependency injection.This is another way of dependency injection 
//	public ProductServiceImpl(ProductRepository productRepository) {
//		this.productRepository = productRepository;
//	}


	public List<Product> searchProducts(String query){
		List<Product> products = productRepository.searchProducts(query);
		return products;
		
	}

	@Override 
	public Product createProduct(Product product) {
		return  productRepository.save(product);
	}


	@Override
	public Integer deleteProductByName(String name) {
		return productRepository.deleteProductByName(name); 
	}
	
}
