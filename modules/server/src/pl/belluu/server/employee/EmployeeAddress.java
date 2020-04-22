package pl.belluu.server.employee;

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
@Table(name= "EmpAddress")
@ComponentScan
public class EmployeeAddress {

    @Id
    @Column(name = "EMA_Id")
    private int id;

    @Column(name = "EMA_City")
    private String city;

    @Column(name = "EMA_Street")
    private String street;

    @Column(name = "EMA_Postcode")
    private String postcode;

    @Column(name = "EMA_FlatNumber")
    private String flatNumber;

    @OneToOne
    @MapsId
    private Employee employee;
}
