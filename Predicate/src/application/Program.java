package application;

import application.util.ProductPredicate;
import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        //list.removeIf(new ProductPredicate());

        //list.removeIf(Product::staticProductPredicate); //Method reference;

        //list.removeIf(Product::nonStaticProductPredicate);

        double min = 100.00;
        //Predicate<Product> pred = p -> p.getPrice() >= min;
        list.removeIf(p -> p.getPrice() >= min);

        for (Product p : list) {
            System.out.println(p.getName() + ", " + p.getPrice());
        }
    }
}
