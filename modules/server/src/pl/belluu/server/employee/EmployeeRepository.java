package pl.belluu.server.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByLastName(String lastName);
    Optional<Employee> findByPESEL(String PESEL);
}
