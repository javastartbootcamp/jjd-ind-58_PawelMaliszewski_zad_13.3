package pl.javastart.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    static List<CurrencyAgainstEuro> createCurrenciesList(String fileName) throws FileNotFoundException {
        List<CurrencyAgainstEuro> currenciesList = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String[] split = sc.nextLine().split(";");
                currenciesList.add(new CurrencyAgainstEuro(split[0], new BigDecimal(split[1])));
            }
        }
        return currenciesList;
    }

    static List<Product> createProductsWithAmendedPricesInEuro(
            String fileName, List<CurrencyAgainstEuro> currencyAgainstEuros) throws FileNotFoundException {
        List<Product> prodList = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String[] split = sc.nextLine().split(";");
                BigDecimal euroPrice = new BigDecimal(0);
                for (CurrencyAgainstEuro currencyAgainstEuro : currencyAgainstEuros) {
                    if (currencyAgainstEuro.getCurrency().equals(split[2])) {
                        euroPrice = euroPrice.add(new BigDecimal(split[1])
                                .divide(currencyAgainstEuro.getConversationRate(), 16, RoundingMode.HALF_UP));
                    }
                }
                prodList.add(new Product(split[0], euroPrice, "EUR"));
            }
        }
        return prodList;
    }
}
