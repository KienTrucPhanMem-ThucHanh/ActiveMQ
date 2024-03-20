package fit.iuh.edu.vn.backends.activemq_control;

import fit.iuh.edu.vn.backends.entities.ProductOrder;
import fit.iuh.edu.vn.backends.ultils.ConvertObject2Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageProducer {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private ConvertObject2Json convertObject2Json;
    public void sendOrderMessage(ProductOrder productOrder){
        String jsonOrder = convertObject2Json.objectToJson(productOrder);
        jmsTemplate.convertAndSend("order.queue", jsonOrder);
    }
}
