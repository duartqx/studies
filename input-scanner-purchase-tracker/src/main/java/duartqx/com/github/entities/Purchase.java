package duartqx.com.github.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Purchase {
    private UUID id;
    private Product product;
    private LocalDateTime boughtAt;

    public Purchase(String productName, Integer price) {
        this.id = UUID.randomUUID();
        this.product = new Product(productName, price);
        this.boughtAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format(
            "%s %s: %d",
            this.getBoughtAt(),
            this.getProductName(),
            this.getProductPrice()
        );
    }

    public LocalDateTime getBoughtAt() {
        return boughtAt;
    }

    public Product getProduct() {
        return product;
    }

    public String getProductName() {
        return product.getName();
    }

    public Integer getProductPrice() {
        return product.getPrice();
    }
}
