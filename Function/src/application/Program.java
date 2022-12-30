package application;

import model.entities.Product;
import model.services.UppercaseName;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));



        //List<String> names = list.stream().map(new UppercaseName()).toList();
        //List<String> names = list.stream().map(Product::nonStaticUppercaseNam).toList();
        //List<String> names = list.stream().map(Product::staticUppercaseName).toList();

        //Function<Product, String> func = p -> p.getName().toUpperCase();
        //List<String> names = list.stream().map(func).toList();

        List<String> names = list.stream().map(p -> p.getName().toUpperCase()).toList();
        names.forEach(System.out::println);

    }
}