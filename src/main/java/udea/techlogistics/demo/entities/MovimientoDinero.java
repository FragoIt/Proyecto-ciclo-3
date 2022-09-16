package udea.techlogistics.demo.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="movements")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private float amount;
    @Column(nullable = false)
    private String concept;
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Empleado usuario;

    public MovimientoDinero() {
    }

    public MovimientoDinero(float amount, String concept, Empleado usuario) {
        this.amount = amount;
        this.concept = concept;
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "amount=" + amount +
                ", concept='" + concept + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
