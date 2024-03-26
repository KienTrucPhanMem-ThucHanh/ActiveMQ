package fit.iuh.edu.vn.backends;

import fit.iuh.edu.vn.backends.entities.Customer;
import fit.iuh.edu.vn.backends.entities.Product;
import fit.iuh.edu.vn.backends.entities.ProductOrder;
import fit.iuh.edu.vn.backends.ultils.ConvertObject2Json;

public class Test {
    public static void main(String[] args) {
        ConvertObject2Json convertObject2Json = new ConvertObject2Json();
        Product product = new Product("Iphone X", 25);
        Customer customer = new Customer("Hiep", "hoaihiep12b1thptlochung2020@gmail.com", "12 NVB");
        ProductOrder productOrder = new ProductOrder(20, product, customer);
        String jsonString = convertObject2Json.objectToJson(productOrder);

        System.out.println(jsonString);
        System.out.println(convertObject2Json.jsonToObject(jsonString, ProductOrder.class));
    }
}
