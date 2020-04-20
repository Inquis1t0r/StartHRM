package pl.belluu.server.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

import lombok.Data;

@Entity
@Data
@Table(name= "EmpContractTerms")
@ComponentScan
public class EmployeeContractTerms {

    @Id
    @Column(name = "EMT_Id")
    private int id;

    @Column(name = "EMT_StartDate")
    private Date startDate;

    @Column(name = "EMT_EndDate")
    private Date endDate;

    @Column(name = "EMT_PositionHeld")
    private String positionHeld;

    @Column(name = "EMT_NetSalary")
    private String netSalary;

    @Column(name = "EMT_GrossSalary")
    private String grossSalary;

    @OneToOne
    @MapsId
    private Employee employee;
}
