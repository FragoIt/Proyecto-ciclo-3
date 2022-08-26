package udea.techlogistics.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		Empresa Carulla = new Empresa("Carulla", "calle 116 #25-03", "6013823746", "890900608-9");

		Empleado Daniel = new Empleado("Daniel Rios", "daniel.rios@gmail.com", "Carulla", Roles.OPERATIVO);

		System.out.println(Carulla.getNombre());
		Carulla.setDireccion("Av 30 #26-05");
		System.out.println(Carulla.getDireccion());

		Carulla.addEmpleado(Daniel);
		System.out.println(Carulla.getEmpleados().size());
		System.out.println(Carulla.getEmpleados().get(0).getNombre());
	}

}
