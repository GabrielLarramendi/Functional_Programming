package model.entities;

import java.util.Comparator;

public class MyComparator implements Comparator<Product> {

    @Override
    public int compare(Product product01, Product product02) {
        return product01.getName().toUpperCase().compareTo(product02.getName().toUpperCase());
    }
}
