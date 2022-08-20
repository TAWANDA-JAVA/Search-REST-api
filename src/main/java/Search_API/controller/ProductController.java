package Search_API.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Search_API.entity.Product;
import Search_API.services.ProductService;

@RestController
@RequestMapping("/api/products") //the base URL 
public class ProductController {
	
	// ProductService instance(injecting ProductService )
	private ProductService productService;

	//Constructor based dependency injection
	//(no need for at @Autowired since they is only constructor and Spring will automatically add @Autowired)
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam("Query")String query){
		return ResponseEntity.ok(productService.searchProducts(query));
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@DeleteMapping("/deleteProduct/{name}")
	public Integer deleteProductByName(@PathVariable String name) {
	  return productService.deleteProductByName(name);
	}
	

	

}
