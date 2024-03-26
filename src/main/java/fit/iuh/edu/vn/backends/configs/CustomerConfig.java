package fit.iuh.edu.vn.backends.configs;

import fit.iuh.edu.vn.backends.entities.Customer;
import fit.iuh.edu.vn.backends.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Autowired
    private CustomerRepository customerRepository;
//    @Bean
    CommandLineRunner addCustomer(){
        return args -> {
            Customer customer = new Customer("Hiep","Go Vap","hoaihiep12b1thptlochung2020@gmail.com");
            customerRepository.save(customer);
        };
    }
}
