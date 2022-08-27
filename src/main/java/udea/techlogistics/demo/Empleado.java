package udea.techlogistics.demo;

import udea.techlogistics.demo.movements.MovimientoDinero;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private String correo;
    private String empresa;
    private Roles roles;
    private List<MovimientoDinero> transacciones;
    public Empleado(String nombre, String correo, String empresa, Roles roles) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.roles = roles;
        this.transacciones = new ArrayList<MovimientoDinero>();
    }

    public List<MovimientoDinero> getTransacciones() {
        return transacciones;
    }

    public void addTransacciones(MovimientoDinero transaccion){
        this.transacciones.add(transaccion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles rolEmpleado) {
        this.roles = rolEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", empresa='" + empresa + '\'' +
                ", roles=" + roles +
                ", transacciones=" + transacciones +
                '}';
    }
}
