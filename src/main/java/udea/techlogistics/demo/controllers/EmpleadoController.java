package udea.techlogistics.demo.controllers;

import org.springframework.web.bind.annotation.*;
import udea.techlogistics.demo.entities.Empleado;
import udea.techlogistics.demo.services.EmpleadoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    private EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Empleado> Employee(){
        return this.service.getEmployee();
    }
    @PostMapping
    public Empleado createEmployee(@RequestBody Empleado empleado){
        return this.service.createEmpleado(empleado);
    }
    @GetMapping("/{employee_id}")
    public Empleado findById(@PathVariable int employee_id ){
        return service.findById( employee_id );
    }
    @PutMapping("/{employee_id}")
    public Empleado updateEmployee(@RequestBody Empleado empleado ){
        if ( service.findById(empleado.getEmployee_id()) != null ){
            return service.updateEmployee( empleado );
        }
        return null;
    }
    @DeleteMapping("/{employee_id}")
    public Empleado deleteEmployee( @PathVariable int employee_id ){
        Empleado employee = service.findById( employee_id );
        if( employee != null){
            service.deleteEmployee( employee );
            return employee;
        }
        return null;
    }
}