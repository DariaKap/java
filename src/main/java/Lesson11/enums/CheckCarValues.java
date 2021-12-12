package Lesson11.enums;

public enum CheckCarValues {

    MAXWIDTH(2.5F), MAXHEIGHT(4), MAXWEIGHT(8);

    private final float value;

    CheckCarValues(float value) {
        this.value = value;
    }

    public float getValue() {
        return this.value;
    }
}
