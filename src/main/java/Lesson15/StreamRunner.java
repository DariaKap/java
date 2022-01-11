package Lesson15;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamRunner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = in.nextLine();


        List<String> list = Arrays.asList(text.toLowerCase().split("[\\p{Blank}\\p{Punct}]"));

        list.stream().filter( a ->  !a.trim().isEmpty())
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((a1, a2) -> {
                    final int res = a2.getValue().compareTo(a1.getValue());
                    return res == 0 ? a1.getKey().compareTo(a2.getKey()) : res;
                })
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

}
