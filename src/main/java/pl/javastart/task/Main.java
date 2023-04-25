package pl.javastart.task;

import java.io.FileNotFoundException;
import java.util.List;

public class  Main {
    public static void main(String[] args) throws FileNotFoundException {

        List<CurrenciesAgainstEuro> currenciesAgainstEuroList =
                FileReader.createCurrenciesList("src\\main\\resources\\currencies.csv");
        List<Products> productsList = FileReader.createProductsList("src\\main\\resources\\products.csv");
        System.out.println(ProductUtils.getSumOfAllProducts(productsList, currenciesAgainstEuroList));
        System.out.println(ProductUtils.getAveragePriceOfAllProducts(productsList, currenciesAgainstEuroList));
        System.out.println(ProductUtils.getMostExpensiveProductPrice(productsList, currenciesAgainstEuroList));
        System.out.println(ProductUtils.getCheapestProductPrice(productsList, currenciesAgainstEuroList));
    }
}
