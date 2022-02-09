package Lesson14;

import java.util.List;
import java.util.Random;

public enum MobileOperator {
    MTS(List.of("910", "915", "916", "917", "919", "985", "986")),
    TELE2(List.of("901", "958", "977", "999")),
    BEELINE(List.of("903", "905", "906", "909", "962", "963", "964", "965", "966", "967", "968", "969", "980", "983", "986")),
    MEGAFON( List.of("925", "926", "929", "936", "999")),
    YOTA(List.of( "995", "996", "999"));

    private final List<String> phoneCodes;

    MobileOperator(List<String> list){
        this.phoneCodes = list;
    }

    public String getCode(){
        return this.phoneCodes.get(new Random().nextInt(this.phoneCodes.size()-1));
    }

    public static MobileOperator getRandomOperator(){
        return List.of(MobileOperator.values()).get(new Random().nextInt(MobileOperator.values().length-1));
    }
}