package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class ProductUtils {

    static BigDecimal getSumOfAllProducts(List<Product> productsList) {
        if (!productsList.isEmpty()) {
            BigDecimal sum = new BigDecimal(0);
            for (Product product : productsList) {
                sum = sum.add(product.getPrice());
            }
            return sum;
        }
        return null;
    }

    static BigDecimal getAveragePriceOfAllProducts(List<Product> productsList) {
        if (!productsList.isEmpty()) {
            BigDecimal numberOfProducts = new BigDecimal(productsList.size());
            return Objects.requireNonNull(getSumOfAllProducts(productsList)).divide(numberOfProducts, 16, RoundingMode.HALF_UP);
        }
        return null;
    }

    static Product getMostExpensiveProductInfo(List<Product> productsList) {
        if (!productsList.isEmpty()) {
            BigDecimal mostExpensive = new BigDecimal(0);
            Product prod = new Product("---", new BigDecimal("0"), "---");
            for (Product product : productsList) {
                if (mostExpensive.compareTo(product.getPrice()) < 0) {
                    mostExpensive = product.getPrice();
                    prod = product;
                }
            }
            return prod;
        }
        return null;
    }

    static Product getCheapestProductInfo(List<Product> productsList) {
        if (!productsList.isEmpty()) {
            BigDecimal cheapest = productsList.get(0).getPrice();
            Product prod = new Product("---", new BigDecimal("0"), "---");
            for (Product product : productsList) {
                if (cheapest.compareTo(product.getPrice()) > 0) {
                    cheapest = product.getPrice();
                    prod = product;
                }
            }
            return prod;
        }
        return null;
    }
}
