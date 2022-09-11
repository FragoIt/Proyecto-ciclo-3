package udea.techlogistics.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Enterprise")
public class Enterprise {
    //attributes
    @Id //primary Key enterprise entity
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int enterprise_id;
    private String enterprise_name;
    private String enterprise_phone;
    private String enterprise_address;
    private LocalDateTime enterprise_createAt;
    private LocalDateTime enterprise_updateAt;
    private String enterprise_nit;
    //constructor

    public Enterprise(String enterprise_name, String enterprise_phone, String enterprise_address, LocalDateTime enterprise_createAt, LocalDateTime enterprise_updateAt, String enterprise_nit) {
        this.enterprise_name = enterprise_name;
        this.enterprise_phone = enterprise_phone;
        this.enterprise_address = enterprise_address;
        this.enterprise_createAt = LocalDateTime.now();
        this.enterprise_updateAt = LocalDateTime.now();
        this.enterprise_nit = enterprise_nit;
    }


    //getters & setters

    public int getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(int enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public String getEnterprise_phone() {
        return enterprise_phone;
    }

    public void setEnterprise_phone(String enterprise_phone) {
        this.enterprise_phone = enterprise_phone;
    }

    public String getEnterprise_address() {
        return enterprise_address;
    }

    public void setEnterprise_address(String enterprise_address) {
        this.enterprise_address = enterprise_address;
    }

    public LocalDateTime getEnterprise_createAt() {
        return enterprise_createAt;
    }

    public void setEnterprise_createAt(LocalDateTime enterprise_createAt) {
        this.enterprise_createAt = enterprise_createAt;
    }

    public LocalDateTime getEnterprise_updateAt() {
        return enterprise_updateAt;
    }

    public void setEnterprise_updateAt(LocalDateTime enterprise_updateAt) {
        this.enterprise_updateAt = enterprise_updateAt;
    }

    public String getEnterprise_nit() {
        return enterprise_nit;
    }

    public void setEnterprise_nit(String enterprise_nit) {
        this.enterprise_nit = enterprise_nit;
    }
}
