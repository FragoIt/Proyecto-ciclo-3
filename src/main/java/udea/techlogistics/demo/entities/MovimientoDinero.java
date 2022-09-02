package udea.techlogistics.demo.entities;

import java.time.LocalDate;

public class MovimientoDinero {
   
   private float amount;
   private String concept;
   private LocalDate createdAt;
   private LocalDate updatedAt;

    public MovimientoDinero(float amount, String concept) {
        this.amount = amount;
        this.concept = concept;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
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
        return "MovimientoDinero{" +
                "amount=" + amount +
                ", concept='" + concept + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
