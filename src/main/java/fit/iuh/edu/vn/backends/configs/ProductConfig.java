package fit.iuh.edu.vn.backends.configs;

import fit.iuh.edu.vn.backends.entities.Product;
import fit.iuh.edu.vn.backends.repositories.ProductQuantityRepository;
import fit.iuh.edu.vn.backends.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductQuantityRepository productQuantityRepository;

//    @Bean
    CommandLineRunner addProduct() {
        return args -> {
            String[] productName = {"Iphone X", "Iphone 14 Promax", "Iphone 15 Promax"};
            for (int i = 0; i < 3; i++) {
//                ProductQuantity productQuantity = new ProductQuantity();
                Product product = new Product(productName[i], 25.5);
                productRepository.save(product);
            }

        };
    }
}
