package udea.techlogistics.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employee")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String emp_id;
    /*@Transient
    private List<Empleado> employees;*/
    @Column(nullable = false)
    private LocalDate createdAt = LocalDate.now();
    @Column(nullable = false)
    private LocalDate updatedAt = LocalDate.now();

    public Empleado() {
    }

    public Empleado(int employee_id, String name, String email, String phone, String emp_id, LocalDate createdAt, LocalDate updatedAt) {
        this.employee_id = employee_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.emp_id = emp_id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
