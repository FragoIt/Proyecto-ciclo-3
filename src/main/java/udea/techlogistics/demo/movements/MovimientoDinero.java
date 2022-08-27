package udea.techlogistics.demo.movements;

public class MovimientoDinero {
   
   private float monto_movimiento;
   private String concepto_movimiento;

    public MovimientoDinero(float monto_movimiento, String concepto_movimiento) {
        this.monto_movimiento = monto_movimiento;
        this.concepto_movimiento = concepto_movimiento;
    }

    public float getMonto_movimiento() {
        return monto_movimiento;
    }

    public void setMonto_movimiento(float monto_movimiento) {
        this.monto_movimiento = monto_movimiento;
    }

    public String getConcepto_movimiento() {
        return concepto_movimiento;
    }

    public void setConcepto_movimiento(String concepto_movimiento) {
        this.concepto_movimiento = concepto_movimiento;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" + "monto_movimiento=" + monto_movimiento + ", concepto_movimiento=" + concepto_movimiento + '}';
    }

}
