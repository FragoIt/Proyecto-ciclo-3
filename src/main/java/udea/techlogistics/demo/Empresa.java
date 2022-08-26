package udea.techlogistics.demo;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    
    private String nombre;
    private String direccion;
    private String telefono;
    private String nit;
    private List<Empleado> empleados;

    public Empresa(String nombre, String direccion, String telefono, String nit) {
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.setNit(nit);
        this.empleados = new ArrayList<Empleado>();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void addEmpleado(Empleado empleado){
        this.empleados.add(empleado);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }

}
