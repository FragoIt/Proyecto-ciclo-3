package udea.techlogistics.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employee")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    @Column(nullable = false)
    private String users;
    @Column(nullable = false)
    private String password;

    private String image;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String document;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;


    //hotfix de enum
    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private Roles role;

    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Empresa enterprise;

    @Column(nullable = false)
    private LocalDate createdAt = LocalDate.now();
    @Column(nullable = false)
    private LocalDate updatedAt = LocalDate.now();

    public Empleado() {
    }
    public Empleado(String users, String password, String name, String document, String email, String phone, Roles role, Empresa enterprise) {
        this.users = users;
        this.password = password;
        this.name = name;
        this.document = document;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.enterprise = enterprise;
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getUsers() { return users;}

    public void setUsers(String users) { this.users = users;}

    public String getPassword() { return password;}

    public void setPassword(String password) { this.password = password; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() { return document; }

    public void setDocument(String document) { this.document = document; }

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

    public Roles getRole() { return role; }

    public void setRole(Roles role) { this.role = role; }

    public Empresa getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Empresa enterprise) {
        this.enterprise = enterprise;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = LocalDate.now();
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = LocalDate.now();
    }

}
