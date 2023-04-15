package pro.sky.maleksandra.employeemap.service;

import java.util.Objects;

public class Employee {
    private final String passportNumber;
    private String firstName;
    private String lastName;

    public Employee(String passportNumber, String lastName, String firstName){
        this.passportNumber=passportNumber;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    public String getPassportNumber(){
        return passportNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }


    @Override
    public String toString(){
        return "Employee: Passport Number =  " + passportNumber +
                ", LastName = " + lastName +
                ", FirstName = " + firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getPassportNumber(), employee.getPassportNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassportNumber());
    }

}
