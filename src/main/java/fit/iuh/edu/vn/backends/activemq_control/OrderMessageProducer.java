package fit.iuh.edu.vn.backends.activemq_control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendOrderMessage(String productOrderJson) {
        jmsTemplate.convertAndSend("order.queue", productOrderJson);
    }
}
