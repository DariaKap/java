package Lesson14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PhoneUtils {

    private static List<String> listOfPhone = new ArrayList<>();

    public static String generatePhone(MobileOperator operator){
        String phone;
        do {
            phone = "+7" + operator.getCode() + new Random().ints(7, 0, 9)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining());
        }
        while (listOfPhone.indexOf(phone) != -1);
        listOfPhone.add(phone);
        return phone;
    }


    public static String generatePhone(){
        return generatePhone(MobileOperator.getRandomOperator());
    }

}
