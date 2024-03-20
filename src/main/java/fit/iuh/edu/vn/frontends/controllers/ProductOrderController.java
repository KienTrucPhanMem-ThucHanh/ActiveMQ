package fit.iuh.edu.vn.frontends.controllers;

import fit.iuh.edu.vn.backends.activemq_control.OrderMessageProducer;
import fit.iuh.edu.vn.backends.entities.Customer;
import fit.iuh.edu.vn.backends.entities.Product;
import fit.iuh.edu.vn.backends.entities.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping()
public class ProductOrderController {

    @Autowired
    private OrderMessageProducer orderMessageProducer;

    @GetMapping()
    public String showHomePage(){
        return "index";
    }

    @PostMapping("/order-product")
    public String orderProduct(
            @RequestParam("tenSP") String tenSP,
            @RequestParam("soLuong") int soLuong,
            @RequestParam("tenKH") String tenKH,
            @RequestParam("email") String email
    ) {
        // Tạo đối tượng ProductOrder từ dữ liệu form
        Product product = new Product(tenSP, 0.0, soLuong);
        Customer customer = new Customer(tenKH, email, "");
        ProductOrder productOrder = new ProductOrder(customer, product, soLuong, LocalDateTime.now());

        // Gửi đơn hàng đến ActiveMQ
        orderMessageProducer.sendOrderMessage(productOrder);

        // Chuyển hướng người dùng đến trang thông báo đặt hàng thành công
        return "order-cuccess";
    }
}
