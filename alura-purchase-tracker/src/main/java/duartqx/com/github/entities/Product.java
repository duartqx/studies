package duartqx.com.github.entities;

public class Product implements  Comparable<Product>{
    private final String name;
    private final Integer price;

    Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product product) {
        return this.price.compareTo(product.price);
    }
}
