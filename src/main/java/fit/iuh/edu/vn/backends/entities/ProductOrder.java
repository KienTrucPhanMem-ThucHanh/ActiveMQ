package fit.iuh.edu.vn.backends.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product-order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product-order-id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "cust-id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "product-id")
    private Product product;

    @Column(nullable = false)
    private int quantity;
    @Column(name = "order-date", nullable = false)
    private LocalDateTime orderDate;

    public ProductOrder(Customer customer, Product product, int quantity, LocalDateTime orderDate) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }
}
