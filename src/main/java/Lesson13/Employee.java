package Lesson13;

public class Employee {
    private final int personnelNumber;
    private String fullName;
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

    public int getPersonnelNumber() {
        return personnelNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(double workExperience) {
        this.workExperience = workExperience;
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

