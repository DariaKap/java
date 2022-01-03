package Lesson13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

public class EmployeeUtils {

    void printEmployee(Collection<Employee> employees, int workAge){


    }

    static void removeByOddIndex(Collection<Employee> employees){
        ListIterator<Employee> iterator = ((ArrayList)employees).listIterator(employees.size());
        while (iterator.hasPrevious()){
            iterator.previous();
            if (!(iterator.previousIndex() % 2 == 0)) {
                iterator.remove();
            }
        }
    }
}
