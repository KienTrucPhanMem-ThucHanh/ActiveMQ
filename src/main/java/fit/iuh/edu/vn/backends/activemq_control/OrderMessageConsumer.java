package fit.iuh.edu.vn.backends.activemq_control;

import fit.iuh.edu.vn.backends.entities.Customer;
import fit.iuh.edu.vn.backends.entities.Product;
import fit.iuh.edu.vn.backends.entities.ProductOrder;
import fit.iuh.edu.vn.backends.entities.ProductQuantity;
import fit.iuh.edu.vn.backends.repositories.CustomerRepository;
import fit.iuh.edu.vn.backends.repositories.ProductOrderRepository;
import fit.iuh.edu.vn.backends.repositories.ProductQuantityRepository;
import fit.iuh.edu.vn.backends.ultils.ConvertObject2Json;
import fit.iuh.edu.vn.backends.ultils.EmailSender;
import fit.iuh.edu.vn.frontends.dto.ProductOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageConsumer {
    @Autowired
    private ConvertObject2Json convertObject2Json;
    @Autowired
    private ProductQuantityRepository productQuantityRepository;
    @Autowired
    private ProductOrderRepository productOrderRepository;
    @Autowired
    private EmailSender emailSender;

    @JmsListener(destination = "order.queue")
    public void receiveOrderMessage(String jsonOrder) {
        System.out.println(jsonOrder);


        ProductOrderDTO productOrderDTO = convertObject2Json.jsonToObject(jsonOrder, ProductOrderDTO.class);
//
        System.out.println("product order sau khi nhận:");
        System.out.println(productOrderDTO);

        String customerEmail = productOrderDTO.getCustomerEmail();
//        // Xu li logic đặt hàng
        boolean orderSuccess = processOrder(productOrderDTO);

        if (orderSuccess) {
            // Gửi email xác nhận đặt hàng thành công
            emailSender.sendEmail(customerEmail, "Thông báo đặt hàng", "Đơn hàng của bạn đã được xác nhận.");
        } else {
            // Gửi email thông báo đặt hàng không thành công
            emailSender.sendEmail(customerEmail, "Thông báo đặt hàng", "Đơn hàng của bạn không thành công. Vui lòng thử lại sau.");
        }

    }

    private boolean processOrder(ProductOrderDTO productOrderDTO) {
        int quantityOrder = productOrderDTO.getQuantity();
        ProductQuantity productQuantity = productQuantityRepository.findByProduct_Id(productOrderDTO.getProductId());
        if (quantityOrder > productQuantity.getQuantity()) {
            return false;
        }
        productQuantity.setQuantity(productQuantity.getQuantity() - quantityOrder);

        Customer customer = new Customer(productOrderDTO.getCustomerId());
        Product product = new Product(productOrderDTO.getProductId());
        ProductOrder productOrder = new ProductOrder(productOrderDTO.getQuantity(), product, customer);


        productQuantityRepository.save(productQuantity);
        productOrderRepository.save(productOrder);


        return true; // Giả sử đơn hàng luôn thành công để minh họa
    }

}
