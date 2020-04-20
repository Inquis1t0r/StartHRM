package pl.belluu.server.employee;

import javax.persistence.Column;

@Entity
@Data
@Table(name= "EmpCont")
@ComponentScan
public class EmployeeContact {

    @Id
    @Column(name = "EMC_Id")
    private int id;

    @Column(name = "EMC_Email")
    private String email;

    @Column(name = "EMC_Phone1")
    private String phone1;

    @Column(name = "EMC_Phone2")
    private String phone2;

    @Column(name = "EMC_Skype")
    private String skype;

    @OneToOne
    @MapsId
    private Employee employee;
}