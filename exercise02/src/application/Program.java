package application;

import model.entities.Product;
import model.services.FileServices;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        String path = "/home/larramendi/IdeaProjects/programacao_funcional/exercise02/src/files/productsAndPrice.csv";
        List<Product> list = FileServices.returnList(path);

        double avg = list.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum) / list.size();

        System.out.println("Average price: R$" + String.format("%.2f", avg));

        Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

        List<String> names = list.stream()
                .filter(x -> x.getPrice() < avg)
                .map(Product::getName)
                .sorted(comp.reversed())
                .toList();

        names.forEach(System.out::println);
    }
}
