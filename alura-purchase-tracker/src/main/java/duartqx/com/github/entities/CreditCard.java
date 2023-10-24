package duartqx.com.github.entities;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private Integer totalCredit;
    private List<Purchase> purchases;

    public CreditCard(Integer credit) {
        this.totalCredit = credit;
        this.purchases = new ArrayList<Purchase>();
    }

    public Integer getSpentCredit() {
        return this.purchases
            .stream()
            .map(Purchase::getProductPrice)
            .reduce(0, Integer::sum);
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public Integer getTotalCredit() {
        return totalCredit;
    }

    public Integer getAvailableCredit() {
        return this.getTotalCredit() - this.getSpentCredit();
    }

    public boolean cannotBuy(Integer price) {
        return this.getSpentCredit() + price > this.totalCredit;
    }

    public boolean addPurchase(Purchase purchase) {
        var price = purchase.getProduct().getPrice();
        if (this.cannotBuy(price)) {
            return false;
        }

        this.purchases.add(purchase);

        return true;
    }
}
