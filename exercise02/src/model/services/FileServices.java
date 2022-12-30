package model.services;

import model.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServices {

    public static List<Product> returnList(String path) {

        List<Product> list = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                String[] field = line.split(",");
                String name = field[0];
                String price = field[1];

                list.add(new Product(name, Double.parseDouble(price)));

                line = br.readLine();
            }
        }
        catch(IOException e){
            e.getMessage();
        }
        return list;
    }
}
