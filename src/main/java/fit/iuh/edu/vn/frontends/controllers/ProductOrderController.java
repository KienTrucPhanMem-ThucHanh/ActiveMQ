package fit.iuh.edu.vn.frontends.controllers;

import fit.iuh.edu.vn.backends.activemq_control.OrderMessageProducer;
import fit.iuh.edu.vn.backends.entities.Customer;
import fit.iuh.edu.vn.backends.entities.Product;
import fit.iuh.edu.vn.backends.entities.ProductOrder;
import fit.iuh.edu.vn.backends.repositories.CustomerRepository;
import fit.iuh.edu.vn.backends.repositories.ProductRepository;
import fit.iuh.edu.vn.backends.ultils.ConvertObject2Json;
import fit.iuh.edu.vn.frontends.dto.ProductOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping()
public class ProductOrderController {

    @Autowired
    private OrderMessageProducer orderMessageProducer;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ConvertObject2Json convertObject2Json;

    @GetMapping()
    public String showHomePage(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        Product defaultProduct = products.get(0);
        model.addAttribute("defaultProduct", defaultProduct);
        return "index";
    }

    @GetMapping("/get-product-price")
    public String getProductPrice(@RequestParam("productName") String productName) {
        Product product = productRepository.findByName(productName);
        double price = product.getPrice();
        return String.valueOf(price);
    }

    @PostMapping("/order-product")
    public String orderProduct(
            @RequestParam("tenSP") String tenSP,
            @RequestParam("soLuong") int soLuong,
            @RequestParam("tenKH") String tenKH,
            @RequestParam("diaChi") String diaChi,
            @RequestParam("email") String email
    ) {
        try {

            Customer customer = customerRepository.findByName(tenKH.toLowerCase());
            Product product = productRepository.findByName(tenSP);

            // Tạo DTO từ dữ liệu đã nhận được từ request
            ProductOrderDTO productOrderDTO = new ProductOrderDTO();
            productOrderDTO.setQuantity(soLuong);
            productOrderDTO.setProductId(product.getId());
            productOrderDTO.setProductName(product.getName());
            productOrderDTO.setProductPrice(product.getPrice());
            productOrderDTO.setCustomerId(customer.getId());
            productOrderDTO.setCustomerName(customer.getName());
            productOrderDTO.setCustomerAddress(customer.getAddress());
            productOrderDTO.setCustomerEmail(customer.getEmail());

            // Chuyển đổi DTO thành JSON
            String jsonProductOrder = convertObject2Json.objectToJson(productOrderDTO);
            System.out.println(jsonProductOrder);

            // Gửi lên ActiveMQ
            orderMessageProducer.sendOrderMessage(jsonProductOrder);

            return "order-cuccess";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }
    }

}
