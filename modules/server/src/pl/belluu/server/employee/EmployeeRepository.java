package pl.belluu.server.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUserName(String userName);
    Employee findByEmail(String email);
    Employee findByLastName(String lastName);
    List<Employee> findByPESEL(String PESEL);

    //TODO Optionals
}
