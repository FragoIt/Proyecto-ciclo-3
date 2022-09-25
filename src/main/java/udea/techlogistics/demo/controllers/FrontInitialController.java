package udea.techlogistics.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import udea.techlogistics.demo.entities.Empleado;
import udea.techlogistics.demo.entities.Empresa;
import udea.techlogistics.demo.entities.MovimientoDinero;
import udea.techlogistics.demo.entities.Roles;
import udea.techlogistics.demo.services.EmpleadoService;
import udea.techlogistics.demo.services.EmpresaService;
import udea.techlogistics.demo.services.MovimientoServices;

import java.util.List;

@Controller
public class FrontInitialController {

    @Autowired
    private EmpresaService serviceEnterprise;
    @Autowired
    private EmpleadoService serviceEmployee;
    @Autowired
    private MovimientoServices serviceMovement;

    //Inicio
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //Empresa
    @GetMapping("/enterprises")
    public String enterprise(Model model){
        List<Empresa> enterprise = this.serviceEnterprise.getEnterprise();
        model.addAttribute("enterprise",enterprise);
        return "enterprise";
    }
    @GetMapping("/enterprisesNew")
    public String newEnterprise(Model model){
        model.addAttribute("enterprise", new Empresa());
        return "enterpriseCreate";
    }
    @PostMapping("/enterprises")
    public RedirectView createEnterprise(@ModelAttribute Empresa empresa, Model model){
        model.addAttribute(empresa);
        this.serviceEnterprise.createEnterprise(empresa);
        return new RedirectView("/enterprises");
    }
    @GetMapping("/enterprisesUpdate/{enterprise_id}")
    public String findById(@PathVariable int enterprise_id, Model model ){
        model.addAttribute("enterprise", serviceEnterprise.findById( enterprise_id ));
        return "enterpriseUpdate";
    }
    @PutMapping("/enterprisesPut/{enterprise_id}")
    public RedirectView updateEnterprise(@PathVariable int enterprise_id, @ModelAttribute("empresa") Empresa empresa, Model model ){
        if ( serviceEnterprise.findById( enterprise_id ) != null ){
            serviceEnterprise.updateEnterprise( empresa );
        }
        return new RedirectView("/enterprises");
    }
    @GetMapping("/enterprisesDelete/{enterprise_id}")
    public RedirectView deleteEnterprise( @PathVariable int enterprise_id ){
        Empresa enterprise = serviceEnterprise.findById( enterprise_id );
        serviceEnterprise.deleteEnterprise( enterprise );
        return new RedirectView("/enterprises");
    }

    //Empleado-Usuario
    @GetMapping("/usersEmployee")
    public String employee(Model model){
        List<Empleado> employee = this.serviceEmployee.getEmployee();
        model.addAttribute("employee",employee);
        return "employees";
    }
    @GetMapping("/employeeNew")
    public String newEployee(Model model){
        model.addAttribute("employee", new Empleado());
        model.addAttribute("Roles", Roles.values());
        return "employeesCreate";
    }
    @PostMapping("/employeeAdd")
    public RedirectView createEmployee(@ModelAttribute Empleado empleado, Model model){
        model.addAttribute(empleado);
        this.serviceEmployee.createEmpleado(empleado);
        return new RedirectView("/usersEmployee");
    }

    //Movimiento
    @GetMapping("/Movements")
    public String movement(Model model){
        List<MovimientoDinero> movement = this.serviceMovement.getMovements();
        model.addAttribute("movement",movement);
        return "movement";
    }

}
