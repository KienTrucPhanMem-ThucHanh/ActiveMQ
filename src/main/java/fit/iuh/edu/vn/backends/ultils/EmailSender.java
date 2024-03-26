package fit.iuh.edu.vn.backends.ultils;

import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class EmailSender {
    public void sendEmail(String recipient, String subject, String body) {
        // Cấu hình thông tin email server
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Thay your_smtp_host bằng địa chỉ SMTP server của bạn
        props.put("mail.smtp.port", "587"); // Thay your_smtp_port bằng cổng SMTP server của bạn (thường là 587 hoặc 465)
        props.put("mail.smtp.auth", "true"); // Bật xác thực SMTP
        props.put("mail.smtp.starttls.enable", "true"); // Kích hoạt TLS

        // Tạo session
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("hoaihiep12b1thptlochung2020@gmail.com", "ylwpmtxmuefajrph"); // Thay your_email và your_password bằng thông tin đăng nhập email của bạn
            }
        });

        try {
            // Tạo đối tượng MimeMessage
            Message message = new MimeMessage(session);

            // Thiết lập người gửi
            message.setFrom(new InternetAddress("hoaihiep12b1thptlochung2020@gmail.com")); // Thay your_email bằng địa chỉ email của bạn

            // Thêm người nhận
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));

            // Thiết lập chủ đề
            message.setSubject(subject);

            // Thiết lập nội dung email
            message.setText(body);

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            System.out.println("Failed to send email. Error: " + e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        String recipient = "hoaihiep12b1thptlochung2020@gmail.com";
//        String subject = "Test email";
//        String body = "This is a test email sent from JavaMail.";
//
//        sendEmail(recipient, subject, body);
//    }
}
