package application;

import model.entities.Employee;
import model.services.FileServices;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String path = "/home/larramendi/IdeaProjects/programacao_funcional/exercise03/src/files/employeeInformation.csv";
        List<Employee> employeeList = FileServices.returnEmployeeList(path);

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        System.out.println("E-mail of people whose salary is more than " + String.format("%.2f", salary) + ":");

        List<String> emailList = employeeList.stream()
                .filter(e -> e.getSalary() > salary)
                .map(Employee::getEmail)
                .sorted()
                .toList();

        emailList.forEach(System.out::println);

        System.out.print("Sum of salary of people whose name starts with 'M': ");

        double sumSalary = employeeList.stream()
                .filter(e -> e.getName()
                .charAt(0) == 'M')
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        System.out.printf("%.2f%n", sumSalary);

        sc.close();
    }
}
