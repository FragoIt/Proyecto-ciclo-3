package udea.techlogistics.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import udea.techlogistics.demo.entities.Empleado;
import udea.techlogistics.demo.entities.Empresa;
import udea.techlogistics.demo.entities.Roles;
import udea.techlogistics.demo.entities.MovimientoDinero;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		/*Empresa Carulla = new Empresa("Carulla", "Calle 117 #26#03", "60143543543", "45-424234");
		Empleado Daniel = new Empleado("fdaniel", "abc", "Felipe Daniel M", "danie@gmail.com", "32454543", "Carulla", Roles.ADMINISTADOR);
		System.out.println(Daniel.toString());
		MovimientoDinero uno = new MovimientoDinero(5000, "Ingreso");
		MovimientoDinero dos = new MovimientoDinero(3000, "Ingreso");
		//Cambio de direccion en empresa Carulla
		System.out.println(Carulla.getName());
		Carulla.setAddress("Av 30 #26-05");
		System.out.println(Carulla.getAddress());
		//Agregar empleado Daniel a empresa Carulla
		Carulla.addEmployees(Daniel);
		System.out.println(Carulla.getEmployees().size());
		System.out.println(Carulla.getEmployees().get(0).getName());
		//Cambio de rol a empleado
		Daniel.setRole(Roles.ADMINISTADOR);
		System.out.println("Este es el cambio del rol  "+Daniel.getRole());
		//Agregar Movimiento de dinero a empleado
		Daniel.addTransactions(uno);
		Daniel.addTransactions(dos);
		System.out.println("Numero de transacciones: "+Daniel.getTransactions().size());
		System.out.println(Daniel.getTransactions().get(0).getAmount());
		System.out.println(Daniel.toString());
		System.out.println("Suma Movimientos: "+(Daniel.getTransactions().get(0).getAmount()+Daniel.getTransactions().get(1).getAmount()));
		*/
	}

}
