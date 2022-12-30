package model.services;

import model.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServices {

    public static List<Employee> returnEmployeeList(String path) {

        List<Employee> employeeList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                String[] employeeFields = line.split(",");
                String name = employeeFields[0];
                String email = employeeFields[1];
                Double salary = Double.parseDouble(employeeFields[2]);
                employeeList.add(new Employee(name, email, salary));
                line = br.readLine();
            }
        }
        catch(IOException e) {
            e.getMessage();
        }

        return employeeList;
    }
}
