package fit.iuh.edu.vn.backends.repositories;

import fit.iuh.edu.vn.backends.entities.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

}