package udea.techlogistics.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name ="movements")
public class MovimientoDinero {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
   private float amount;
   private String concept;
   private LocalDateTime createdAt;
   private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado usuario;

    public MovimientoDinero() {
    }


    public MovimientoDinero(Long id, float amount, String concept, LocalDateTime createdAt, LocalDate updatedAt, Empleado usuario) {
        this.id = id;
        this.amount = amount;
        this.concept = concept;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
    @PrePersist
    public void asignarFechaRegistro() {
        createdAt = LocalDateTime.now();
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
