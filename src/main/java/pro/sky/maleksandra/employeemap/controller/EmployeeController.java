package pro.sky.maleksandra.employeemap.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.maleksandra.employeemap.exceptions.EmployeeNotFoundException;
import pro.sky.maleksandra.employeemap.service.Employee;
import pro.sky.maleksandra.employeemap.service.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService service){
        this.employeeService = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam (name="passportNumber", required = false) String passportNumber,
                                @RequestParam (name="firstName", required = false) String firstName,
                                @RequestParam (name = "lastName", required = false) String lastName){

        return employeeService.addEmployee(passportNumber,lastName, firstName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam (name="passportNumber", required = false) String passportNumber){
        return employeeService.removeEmployee(passportNumber);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam (name="passportNumber", required = false) String passportNumber){

        return employeeService.findEmployee(passportNumber);
    }

    @GetMapping("/show")
    public Map<String, Employee> showAllEmployees(){
        return employeeService.showAllEmployees();
    }

    @ExceptionHandler
    public ResponseEntity<String> handleEmployeeNotFoundedException (EmployeeNotFoundException exc){
        return new ResponseEntity<>("ERROR.The employee doesn't exist in the list.", HttpStatus.BAD_REQUEST);
    }

}
