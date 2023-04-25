package pl.javastart.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    static List<CurrenciesAgainstEuro> createCurrenciesList(String fileName) throws FileNotFoundException {
        List<CurrenciesAgainstEuro> currenciesList = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String[] split = sc.nextLine().split(";");
                currenciesList.add(new CurrenciesAgainstEuro(split[0], new BigDecimal(split[1])));
            }
        }
        return currenciesList;
    }

    static List<Products> createProductsList(String fileName) throws FileNotFoundException {
        List<Products> prodList = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String[] split = sc.nextLine().split(";");
                prodList.add(new Products(split[0], new BigDecimal(split[1]), split[2]));
            }
        }
        return prodList;
    }
}
