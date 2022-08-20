package Search_API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import Search_API.entity.Product;

// No need for @Repository bcoz JpaRepository internally implements it
public interface ProductRepository extends JpaRepository<Product, Long> {

	// JPQL QUERY for searching Products by id or description
	@Query("SELECT p FROM Product p WHERE " + "p.name LIKE CONCAT('%',:query,'%')"
			+ " Or p.id LIKE CONCAT('%',:query,'%' )" + " Or p.description LIKE CONCAT('%',:query, '%')")
	List<Product> searchProducts(String query);

 	// JPQL Deleting method
	@Transactional
	@Modifying
	@Query("DELETE FROM Product WHERE name = :name")
	Integer deleteProductByName(String name);

	/*
	 * //Native SQL QUERY for searching Products by id or description
	 * 
	 * @Query(value = "SELECT * FROM products p WHERE " +
	 * "p.name LIKE CONCAT('%',:query,'%' )" +
	 * " Or p.description LIKE CONCAT('%',:query, '%')" , nativeQuery = true)
	 * List<Product> searchProducts(String query);
	 */

}
