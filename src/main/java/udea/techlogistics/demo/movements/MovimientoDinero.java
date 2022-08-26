/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.techlogistics.demo.movements;

/**
 *
 * @author SANTIAGO FRAGOSO
 */
public class MovimientoDinero {
   
   private float monto_movimiento;
   private String concepto_movimiento;
   private int id_usuario;

    public MovimientoDinero(float monto_movimiento, String concepto_movimiento, int id_usuario) {
        this.monto_movimiento = monto_movimiento;
        this.concepto_movimiento = concepto_movimiento;
        this.id_usuario= id_usuario;
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

    public int getID_USUARIO() {
        return id_usuario;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" + "monto_movimiento=" + monto_movimiento + ", concepto_movimiento=" + concepto_movimiento + ", ID_USUARIO=" + id_usuario + '}';
    }
   
   
   
    
}
