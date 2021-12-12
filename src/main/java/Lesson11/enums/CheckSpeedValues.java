package Lesson11.enums;

public enum CheckSpeedValues {

    SPEEDLIMIT80(80), SPEEDLIMIT100(100);

    private final int value;

    CheckSpeedValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
