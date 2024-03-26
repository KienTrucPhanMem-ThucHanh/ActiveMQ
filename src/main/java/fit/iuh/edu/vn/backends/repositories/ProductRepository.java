package fit.iuh.edu.vn.backends.repositories;

import fit.iuh.edu.vn.backends.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
}