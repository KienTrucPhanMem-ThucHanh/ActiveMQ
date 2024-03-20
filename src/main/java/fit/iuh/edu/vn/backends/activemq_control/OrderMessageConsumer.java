package fit.iuh.edu.vn.backends.activemq_control;

import fit.iuh.edu.vn.backends.entities.Customer;
import fit.iuh.edu.vn.backends.entities.ProductOrder;
import fit.iuh.edu.vn.backends.ultils.ConvertObject2Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageConsumer {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired

    private ConvertObject2Json convertObject2Json;
    @JmsListener(destination = "order.queue")
    public void receiveOrderMessage(String jsonOrder) {

        // Chuyển từ json sang object khi lắng nghe từ jms
        ProductOrder productOrder = convertObject2Json.jsonToObject(jsonOrder, ProductOrder.class);
        System.out.println("product order:");

        System.out.println(productOrder);

        // xu li logic dat hang

        // Sau khi xu li xong thi gui mail
//        sendEmail(productOrdegetName().toString());
    }

    private void sendEmail(String recipient, String message) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipient);
        email.setSubject("Order Notification");
        email.setText(message);
        javaMailSender.send(email);
    }
}
