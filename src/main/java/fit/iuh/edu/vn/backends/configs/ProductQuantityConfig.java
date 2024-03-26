package fit.iuh.edu.vn.backends.configs;

import fit.iuh.edu.vn.backends.entities.Product;
import fit.iuh.edu.vn.backends.entities.ProductQuantity;
import fit.iuh.edu.vn.backends.repositories.ProductQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductQuantityConfig {
    @Autowired
    private ProductQuantityRepository productQuantityRepository;

//        @Bean
    CommandLineRunner addProductQuantity() {
        return args -> {
            for (int i = 0; i < 3; i++) {
                long productId =  i;
                int proQuan = 100;
                ProductQuantity productQuantity = new ProductQuantity(proQuan * 2, new Product(productId + 1));
                productQuantityRepository.save(productQuantity);
            }
        };
    }
}
