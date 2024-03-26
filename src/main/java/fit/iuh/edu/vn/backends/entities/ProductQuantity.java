package fit.iuh.edu.vn.backends.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductQuantity(long id) {
        this.id = id;
    }

    public ProductQuantity(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductQuantity{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
