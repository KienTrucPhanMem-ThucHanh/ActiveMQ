package fit.iuh.edu.vn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActiveMqDemoApplication {

    public static void main(String[] args) {
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
//        connectionFactory.setBrokerURL("tcp://hostname:61616");
//        connectionFactory.setUserName("admin");
//        connectionFactory.setPassword("admin");
        SpringApplication.run(ActiveMqDemoApplication.class, args);
    }

}
