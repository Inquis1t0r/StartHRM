package pl.belluu.server.employee;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
@Table(name= "EmpId")
@ComponentScan
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMI_Id")
    private int id;

    @Column(name = "EMI_FirstName")
    private String firstName;

    @Column(name = "EMI_SecondName")

    @Column(name = "EMI_LastName")
    private String lastName;

    @Column(name = "EMI_Age")
    private byte age;

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

}
