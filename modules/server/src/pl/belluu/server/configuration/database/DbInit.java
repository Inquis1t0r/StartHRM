package pl.belluu.server.configuration.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.belluu.server.employee.Employee;
import pl.belluu.server.employee.EmployeeRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private EmployeeRepository employeeRepository;

    public DbInit(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Employee admin = new Employee("admin","admin@starthrm.pl","admin2","ADMIN","");
        Employee user = new Employee("user","user@starthrm.pl","userpw","USER","");
        Employee hr = new Employee("hr","hr@starthrm.pl","hrpw","HR","");

        List<Employee> employees = Arrays.asList(admin,user,hr);

        this.employeeRepository.saveAll(employees);
    }
}
