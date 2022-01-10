package Lesson13;

import lombok.Getter;
import lombok.Setter;

public class Employee {
    @Getter
    private final int personnelNumber;
    @Getter
    private String fullName;
    @Getter
    @Setter
    private double workExperience;

    public Employee(int personnelNumber, String fullName, double workExperience) {
        this.personnelNumber = personnelNumber;
        this.fullName = fullName;
        this.workExperience = workExperience;
    }

    public Employee(int personnelNumber, String fullName) {
        this.personnelNumber = personnelNumber;
        this.fullName = fullName;
        this.workExperience = 0.0d;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Табельный номер=" + personnelNumber +
                ", ФИО='" + fullName + '\'' +
                ", Стаж работы=" + workExperience +
                '}';
    }
}

