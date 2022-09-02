package udea.techlogistics.demo.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String user;
    private String password;
    private String image;
    private String name;
    private String email;
    private String phone;
    private String enterprise;
    private Roles role;
    private List<MovimientoDinero> transactions;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Empleado(String user, String password, String name, String email, String phone, String enterprise, Roles role) {
        this.setUser(user);
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
        this.setEnterprise(enterprise);
        this.setRole(role);
        this.transactions = new ArrayList<MovimientoDinero>();
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public List<MovimientoDinero> getTransactions() {
        return transactions;
    }

    public void addTransactions(MovimientoDinero transaction){
        this.transactions.add(transaction);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", enterprise='" + enterprise + '\'' +
                ", role=" + role +
                ", transactions=" + transactions +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
