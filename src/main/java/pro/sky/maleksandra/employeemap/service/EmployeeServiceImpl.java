package pro.sky.maleksandra.employeemap.service;

import org.springframework.stereotype.Service;
import pro.sky.maleksandra.employeemap.exceptions.EmployeeNotFoundException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeBook;
    public EmployeeServiceImpl(){
        this.employeeBook = new HashMap<>();
    }

    public Employee addEmployee(String passportNumber, String lastName, String firstName) {
        Employee e = new Employee(passportNumber, firstName, lastName);
        employeeBook.put(passportNumber, e);
        System.out.println("New employee has been added successfully.");
        return e;

    }

    public Employee removeEmployee (String passportNumber) {
        Employee e = findEmployee(passportNumber);
        employeeBook.remove(passportNumber);
        System.out.println("The employee has been deleted successfully.");

        return e;

    }

    public Employee findEmployee(String passportNumber) {

        if(employeeBook.get(passportNumber)==null){
            throw new EmployeeNotFoundException();
        }
        return employeeBook.get(passportNumber);
    }

    public Map<String, Employee> showAllEmployees() {
        return Collections.unmodifiableMap(employeeBook);
    }

}
