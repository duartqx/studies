package duartqx.com.github.service;

import duartqx.com.github.entities.CreditCard;
import duartqx.com.github.entities.Purchase;

public class ShoppingService {
    private CreditCard creditCard;

    public ShoppingService(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public boolean buy(String productName, Integer productPrice) {
        Purchase p = new Purchase(productName, productPrice);
        return this.creditCard.addPurchase(p);
    }

    public boolean hasCredit() {
        return this.creditCard.getAvailableCredit() > 0;
    }

    public Integer getSpent() {
        return this.creditCard.getSpentCredit();
    }

    public Integer getTotalCredit() {
        return this.creditCard.getTotalCredit();
    }

    @Override
    public String toString() {
        return String.format(
            (
                "#####################\n" +
                "totalSpend: %d\n" +
                "availableCredit: %d\n" +
                "Products bought: %s\n" +
                "#####################\n"
            ),
            this.creditCard.getSpentCredit(),
            this.creditCard.getAvailableCredit(),
            this.creditCard.getPurchases().toString()
        );
    }
}
