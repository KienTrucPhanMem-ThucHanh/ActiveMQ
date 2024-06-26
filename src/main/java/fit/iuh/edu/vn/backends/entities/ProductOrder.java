package fit.iuh.edu.vn.backends.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product-order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public ProductOrder(int quantity, Product product, Customer customer) {
        this.quantity = quantity;
        this.product = product;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                ", customer=" + customer +
                '}';
    }
}
