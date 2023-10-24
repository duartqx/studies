package duartqx.com.github;

import duartqx.com.github.entities.CreditCard;
import duartqx.com.github.entities.Purchase;
import duartqx.com.github.service.ShoppingService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String action = "";
        String productName;
        Integer productPrice;

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the total credit of your card? ");
        Integer totalCredit = scanner.nextInt();

        ShoppingService shoppingService = new ShoppingService((new CreditCard(totalCredit)));

        while (!action.equals("q")) {

            System.out.printf(
                "Spent: %d / Total Credit: %d\n",
                shoppingService.getSpent(),
                shoppingService.getTotalCredit()
            );
            System.out.println("Choose an action: (b) Buy / (q) Quit");
            action = scanner.next();

            if (action.equals("b")) {
                System.out.println("What is the product name? ");
                productName = scanner.next();

                System.out.println("What is the product price? ");
                productPrice = scanner.nextInt();

                if (!shoppingService.buy(productName, productPrice)) {
                    System.out.println("Thats too much for your credits!");
                }

                if (!shoppingService.hasCredit()) {
                    break;
                }
            }
        }
        System.out.println(shoppingService.toString());
    }
}