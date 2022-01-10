package Lesson13;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class EmployeeRunner {

    @SneakyThrows({IOException.class})
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        Set<Employee> employeeSet = new LinkedHashSet<>();
        Queue<Employee> employeeQueue = new LinkedList<>();

        String line;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(EmployeeRunner.class.getResourceAsStream("/Employees.txt"),
                        StandardCharsets.UTF_8.name()))) {
            System.out.println("Список сотрудников: ");
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(";");
                Employee emp = new Employee(Integer.parseInt(employee[0]), employee[1], Double.parseDouble(employee[2]));
                System.out.println(emp);
                employeeList.add(emp);
                employeeSet.add(emp);
                employeeQueue.add(emp);
            }
        }

        double[] searchExp = new double[]{2.4, 2};


        System.out.println("----------------------Список--------------------------");
        for (double s : searchExp) {
            System.out.println("Ищем сотрудников со стажем = " + s);
            EmployeeUtils.printEmployee(employeeList, s);
        }
        System.out.println("Удалим сотрудников на нечетных позициях. Оставшие: ");
        employeeList = new ArrayList<>(EmployeeUtils.removeByOddIndex(employeeList));
        EmployeeUtils.printEmployeeAll(employeeList);

        System.out.println("----------------------Множество--------------------------");
        for (double s:searchExp) {
            System.out.println("Ищем сотрудников со стажем = " + s);
            EmployeeUtils.printEmployee(employeeSet, s);
        }
        System.out.println("Удалим сотрудников на нечетных позициях. Оставшие: ");
        employeeSet = new LinkedHashSet<>(EmployeeUtils.removeByOddIndex(employeeSet));
        EmployeeUtils.printEmployeeAll(employeeSet);

        System.out.println("----------------------Очередь--------------------------");
        for (double s:searchExp) {
            System.out.println("Ищем сотрудников со стажем = " + s);
            EmployeeUtils.printEmployee(employeeQueue, s);
        }
        System.out.println("Удалим сотрудников на нечетных позициях. Оставшие: ");
        employeeQueue = new LinkedList<>(EmployeeUtils.removeByOddIndex(employeeQueue));
        EmployeeUtils.printEmployeeAll(employeeQueue);
    }
}
