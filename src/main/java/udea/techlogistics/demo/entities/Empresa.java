package udea.techlogistics.demo.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    
    private String name;
    private String address;
    private String phone;
    private String nit;
    private List<Empleado> employees;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Empresa(String name, String address, String phone, String nit) {
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
        this.setNit(nit);
        this.employees = new ArrayList<Empleado>();
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public List<Empleado> getEmployees() {
        return employees;
    }

    public void addEmployees(Empleado employee){
        this.employees.add(employee);
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
