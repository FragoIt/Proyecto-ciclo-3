package udea.techlogistics.demo.services;

import udea.techlogistics.demo.entities.Empleado;
import udea.techlogistics.demo.entities.Empresa;
import udea.techlogistics.demo.entities.Roles;

public class EmpresaService {

    Empresa Carulla;
    Empleado Daniel;

    public EmpresaService(){
        this.Carulla = new Empresa("Carulla", "Calle 117 #26#03", "60143543543", "45-424234");
        this.Daniel = new Empleado("fdaniel", "abc", "Felipe Daniel M", "danie@gmail.com", "32454543", "Carulla", Roles.ADMINISTADOR);
        Carulla.addEmployees(Daniel);
    }

    public Empresa getEnterprise(){
        return this.Carulla;
    }
}
