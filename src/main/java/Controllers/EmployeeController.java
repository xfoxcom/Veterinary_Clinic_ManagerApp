package Controllers;

import Entities.Employee;
import Repositories.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/alive")
    public String isAlive() {
        return "Alive";
    }
}
