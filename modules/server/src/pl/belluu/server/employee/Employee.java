package pl.belluu.server.employee;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@Table(name = "EmpId")
@ComponentScan
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMI_Id")
    private int id;

    @Column(name = "EMI_FirstName")
    private String firstName;

    @Column(name = "EMI_SecondName")
    private String secondName;

    @Column(name = "EMI_LastName")
    private String lastName;

    @Column(name = "EMI_UserName")
    private String userName;

    @Column(name = "EMI_Email")
    private String email;

    @Column(name = "EMI_Password")
    private String password;

    @Column(name = "EMI_Age")
    private int age;

    @Column(name = "EMI_Sex")
    private byte sex;

    @Column(name = "EMI_Pesel")
    private String PESEL;

    @Column(name = "EMI_Ppn")
    private String PPN;

    @Column(name = "EMI_Active", columnDefinition = "boolean default false")
    private Boolean active;

    @Column(name = "EMI_Archival", columnDefinition = "boolean default false")
    private Boolean archival;

    @Column(name = "EMI_Roles")
    private String roles = "";

    @Column(name = "EMI_Permissions")
    private String permissions = "";

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

    public Employee(String userName,String email, String password, String roles, String permissions) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.active = true;
    }

    protected Employee(){}
}
