package pl.belluu.server.employee;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class EmployeePrincipalDetailsService implements UserDetailsService {
    private EmployeeRepository employeeRepository;

    public EmployeePrincipalDetailsService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee employee = this.employeeRepository.findByUserName(s);
        EmployeePrincipal employeePrincipal = new EmployeePrincipal(employee);

        return employeePrincipal;
    }
}
