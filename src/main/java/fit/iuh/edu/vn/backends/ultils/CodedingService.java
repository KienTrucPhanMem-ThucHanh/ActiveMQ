package fit.iuh.edu.vn.backends.ultils;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class CodedingService {
    public String encode(String informatinString) {
        return Base64.getEncoder().encodeToString(informatinString.getBytes());
    }

    public String decode(String encodeString) {
        byte[] decodeBytes = Base64.getDecoder().decode(encodeString);
        return new String(decodeBytes);
    }
}
