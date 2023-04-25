package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProductUtils {

    static BigDecimal getSumOfAllProducts(List<Products> productsList, List<CurrenciesAgainstEuro> currenciesList) {
        BigDecimal sum = new BigDecimal(0);
        for (Products products : productsList) {
            BigDecimal euPrice = getEuroPrice(products, currenciesList);
            sum = sum.add(euPrice);
        }
        return sum;
    }

    private static BigDecimal getEuroPrice(Products product, List<CurrenciesAgainstEuro> currenciesList) {
        return product.getPrice().divide(findCurrency(product.getCurrency(), currenciesList), 16, RoundingMode.HALF_UP);
    }

    static BigDecimal getAveragePriceOfAllProducts(List<Products> productsList, List<CurrenciesAgainstEuro> currenciesList) {
        BigDecimal numberOfProducts = new BigDecimal(productsList.size());
        BigDecimal allProdPrice = getSumOfAllProducts(productsList, currenciesList);
        return allProdPrice.divide(numberOfProducts, 16, RoundingMode.HALF_UP);
    }

    static BigDecimal getMostExpensiveProductPrice(List<Products> productsList, List<CurrenciesAgainstEuro> currenciesList) {
        BigDecimal mostExpensive = new BigDecimal(0);
        for (Products product : productsList) {
            BigDecimal euPrice = getEuroPrice(product, currenciesList);
            if (mostExpensive.compareTo(euPrice) < 0) {
                mostExpensive = euPrice;
            }
        }
        return mostExpensive;
    }

    static BigDecimal getCheapestProductPrice(List<Products> productsList, List<CurrenciesAgainstEuro> currenciesList) {
        BigDecimal cheapest = productsList.get(0).getPrice();
        for (Products product : productsList) {
            BigDecimal euPrice = getEuroPrice(product, currenciesList);
            if (cheapest.compareTo(euPrice) > 0) {
                cheapest = euPrice;
            }
        }
        return cheapest;
    }

    private static BigDecimal findCurrency(String productCurrency, List<CurrenciesAgainstEuro> caeList) {
        for (CurrenciesAgainstEuro currency : caeList) {
            if (productCurrency.equals(currency.getCurrency())) {
                return currency.getConversationRate();
            }
        }
        return new BigDecimal(0);
    }
}
