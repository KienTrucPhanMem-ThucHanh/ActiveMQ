package fit.iuh.edu.vn.frontends.dto;

import fit.iuh.edu.vn.backends.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductOrderDTO {
    private long id;
    private int quantity;
    private long productId;
    private String productName;
    private double productPrice;
    private long customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;

    @Override
    public String toString() {
        return "ProductOrderDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}
