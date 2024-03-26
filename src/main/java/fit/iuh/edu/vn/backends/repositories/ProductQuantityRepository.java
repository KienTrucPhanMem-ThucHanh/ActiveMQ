package fit.iuh.edu.vn.backends.repositories;

import fit.iuh.edu.vn.backends.entities.ProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductQuantityRepository extends JpaRepository<ProductQuantity, Long> {
    ProductQuantity findByProduct_Id(long id);
}