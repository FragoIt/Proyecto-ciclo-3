package udea.techlogistics.demo.entities;


import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;
import java.util.Date;


public class Employee {
    //attributes
    @Id //primary Key enterprise entity
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_id;
    private int employee_nid;
    private String employee_name;
    private String employee_user;
    private String employee_email;
    private Date employee_createat;
    private Date employee_updateat;
    private String employee_role;


    //constructor


    //getters & setters

}
