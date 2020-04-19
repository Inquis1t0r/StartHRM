package pl.belluu.server.employee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/employees")
    public ResponseEntity getEmployees() throws JsonProcessingException{
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(objectMapper.writeValueAsString(employees));
    }

    public ResponseEntity getEmployeeByLastName(String lastName) throws JsonProcessingException{
        Optional<Employee> employee = employeeRepository.findByLastName(lastName);
                return ResponseEntity.ok(employee);
    }

    public ResponseEntity getEmployeeByPESEL(String PESEL) throws JsonProcessingException{
        Optional<Employee> employee = employeeRepository.findByLastName(PESEL);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/employees")
    public ResponseEntity addEmployee(@RequestBody Employee employee) throws JsonProcessingException{
        Optional<Employee> peselFromDatabase = employeeRepository.findByPESEL(employee.getPESEL());

        if (peselFromDatabase.isPresent()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Employee saveEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(saveEmployee);

    }

}
