package Lesson11;

import Lesson11.enums.CheckCarValues;
import Lesson11.exceptions.FailedPassCheckpoint;

public class CheckPont {

    public static void check(Automobile auto) {
        if (auto.getHeight() > CheckCarValues.MAXHEIGHT.getValue() ||
                auto.getWidth() > CheckCarValues.MAXWIDTH.getValue() ||
                auto.getWeight() > CheckCarValues.MAXWEIGHT.getValue()) {
            throw new FailedPassCheckpoint(auto.getTypeCar(), auto.getCarNumber());
        }
        System.out.println(auto.getTypeCar() + " проехал через КПП");
    }

}
