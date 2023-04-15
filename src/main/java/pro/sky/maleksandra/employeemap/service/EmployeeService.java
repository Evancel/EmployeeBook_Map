package pro.sky.maleksandra.employeemap.service;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String passportNumber, String lastName, String firstName);
    Employee removeEmployee(String passportNumber);
    Employee findEmployee(String passportNumber);
    Map<String, Employee> showAllEmployees();
}

