package Lesson13;

import java.util.*;

public class EmployeeUtils {

    static void printEmployeeAll(Collection<Employee> employees) {
        for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }

    static void printEmployee(Collection<Employee> employees, double workAge) {
        boolean outputed = false;
        for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee employee = iterator.next();
            if (employee.getWorkExperience() == workAge) {
                System.out.println(employee);
                outputed = true;
            }
        }
        if (!(outputed)) {
            System.out.println("Сотрудник со стажем " + workAge + " не найден");
        }
    }

    static Collection<Employee> removeByOddIndex(Collection<Employee> employees) {
        List<Employee> list = new ArrayList<>(employees);
        ListIterator<Employee> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            iterator.previous();
            if (!(iterator.previousIndex() % 2 == 0)) {
                iterator.remove();
            }
        }
        return list;
    }
}
