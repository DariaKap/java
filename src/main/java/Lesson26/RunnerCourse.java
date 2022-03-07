package Lesson26;

import Lesson26.service.ValCourse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Scanner;

public class RunnerCourse {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext("Lesson26");
        ValCourse valCourse = appContext.getBean(ValCourse.class);
        Scanner in = new Scanner(System.in);
        boolean doProgram = true;
        String closedWord = "exit";
        String searchVal;
        String label = """
                Получение курса по интересующей валюте, указывая ее сокращенное наименование (например, USD, EUR, KZT).
                Для выхода из программы введите\s""" + closedWord +
                "\n>>";
        do {
            System.out.print(label);
            while (!in.hasNextLine()) {
                System.out.print(label);
                in.next();
            }
            searchVal = in.nextLine().toUpperCase();
            if (searchVal.equals(closedWord.toUpperCase())) {
                doProgram = false;
            } else {
                BigDecimal result = valCourse.getCurrentCoursesVal(searchVal);
                if (result == null) {
                    System.out.println("Курс валюты неопределен.");
                } else {
                    System.out.printf("Курс равен %.2f\n", result);
                }
            }
        } while (doProgram);
    }
}
