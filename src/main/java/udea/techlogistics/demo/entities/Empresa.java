package udea.techlogistics.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="enterprise")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enterprise_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String nit;

    @Column(nullable = false)
    private LocalDate createdAt = LocalDate.now();
    @Column(nullable = false)
    private LocalDate updatedAt = LocalDate.now();

    public Empresa() {
    }

    public Empresa(String name, String address, String phone, String nit) {
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
        this.setNit(nit);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public int getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(int enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {this.createdAt = LocalDate.now();}

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = LocalDate.now();
    }
}
