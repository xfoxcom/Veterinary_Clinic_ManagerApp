package Entities;

public enum JobTitle {
    DOCTOR(120000),
    ASSISTANT(65000),
    ADMINISTRATOR(35000);

    private final int salary;

    JobTitle(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
