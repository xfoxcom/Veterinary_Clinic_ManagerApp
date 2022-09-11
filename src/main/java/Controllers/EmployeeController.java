package Controllers;

import Entities.Employee;
import Repositories.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee")
    public Employee getEmployeeByLastname(@RequestParam(name = "lastname") String lastname) {
       return employeeRepository.findByLastname(lastname).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/employee")
    public ResponseEntity<String> deleteEmployee(@RequestParam String lastname) {
        employeeRepository.deleteByLastname(lastname);
        return ResponseEntity.ok(lastname + " is fired.");
    }

}
