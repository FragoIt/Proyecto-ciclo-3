package udea.techlogistics.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import udea.techlogistics.demo.movements.MovimientoDinero;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		Empresa Carulla = new Empresa("Carulla", "calle 116 #25-03", "6013823746", "890900608-9");
		Empleado Daniel = new Empleado("Daniel Rios", "daniel.rios@gmail.com", "Carulla", Roles.OPERATIVO);
		MovimientoDinero uno = new MovimientoDinero(5000, "Ingreso");
		MovimientoDinero dos = new MovimientoDinero(3000, "Ingreso");
		//Cambio de direccion en empresa Carulla
		System.out.println(Carulla.getNombre());
		Carulla.setDireccion("Av 30 #26-05");
		System.out.println(Carulla.getDireccion());
		//Agregar empleado Daniel a empresa Carulla
		Carulla.addEmpleado(Daniel);
		System.out.println(Carulla.getEmpleados().size());
		System.out.println(Carulla.getEmpleados().get(0).getNombre());
		//Cambio de rol a empleado
		Daniel.setRoles(Roles.ADMINISTADOR);
		System.out.println("Este es el cambio del rol  "+Daniel.getRoles());
		//Agregar Movimiento de dinero a empleado
		Daniel.addTransacciones(uno);
		Daniel.addTransacciones(dos);
		System.out.println("Numero de transacciones: "+Daniel.getTransacciones().size());
		System.out.println(Daniel.getTransacciones().get(0).getMonto_movimiento());
		System.out.println(Daniel.toString());
		System.out.println("Suma Movimientos: "+(Daniel.getTransacciones().get(0).getMonto_movimiento()+Daniel.getTransacciones().get(1).getMonto_movimiento()));
	}

}
