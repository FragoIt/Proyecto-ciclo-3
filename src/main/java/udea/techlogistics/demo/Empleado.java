package udea.techlogistics.demo;

public class Empleado {
    private String nombre;
    private String correo;
    private String empresa;
    private Roles roles;
    public Empleado(String nombre, String correo, String empresa, Roles roles) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.roles = roles;
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
}
