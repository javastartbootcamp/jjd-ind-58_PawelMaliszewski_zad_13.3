package pl.javastart.task;

import java.io.FileNotFoundException;
import java.util.List;

public class  Main {
    public static void main(String[] args) throws FileNotFoundException {

        List<CurrencyAgainstEuro> currenciesAgainstEuroList =
                FileReader.createCurrenciesList("src\\main\\resources\\currencies.csv");
        List<Product> products =
                FileReader.createProductsWithAmendedPricesInEuro(
                        "src\\main\\resources\\products.csv", currenciesAgainstEuroList);

        System.out.println("Suma wszystkich produktów: " + ProductUtils.getSumOfAllProducts(products));
        System.out.println("Średnia wartość produktu: " + ProductUtils.getAveragePriceOfAllProducts(products));
        System.out.println("Najdroższy produkt: " + ProductUtils.getMostExpensiveProductInfo(products));
        System.out.println("Najtańszy produkt: " + ProductUtils.getCheapestProductInfo(products));
    }
}
