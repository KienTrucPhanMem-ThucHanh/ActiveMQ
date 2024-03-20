package fit.iuh.edu.vn.backends.repositories;

import fit.iuh.edu.vn.backends.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
