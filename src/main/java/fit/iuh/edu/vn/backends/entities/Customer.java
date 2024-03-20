package fit.iuh.edu.vn.backends.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust-id")
    private long id;
    private String name;
    private String email;
    private String address;

    public Customer(long id) {
        this.id = id;
    }

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
