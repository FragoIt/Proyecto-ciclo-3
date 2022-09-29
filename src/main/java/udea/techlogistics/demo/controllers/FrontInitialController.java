package udea.techlogistics.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import udea.techlogistics.demo.entities.Empleado;
import udea.techlogistics.demo.entities.Empresa;
import udea.techlogistics.demo.entities.MovimientoDinero;
import udea.techlogistics.demo.entities.Roles;
import udea.techlogistics.demo.services.EmpleadoService;
import udea.techlogistics.demo.services.EmpresaService;
import udea.techlogistics.demo.services.MovimientoServices;

import java.util.ArrayList;
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
        this.serviceEnterprise.createEnterprise(empresa);        return new RedirectView("/enterprises");
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
//        String passEncriptada=passwordEncoder().encode(empleado.getPassword());
//        empleado.setPassword(passEncriptada);

        model.addAttribute(empleado);
        this.serviceEmployee.createEmpleado(empleado);
        return new RedirectView("/usersEmployee");
    }
    @GetMapping("/employerUpdate/{employee_id}")
    public String findByIdEmployee(@PathVariable int employee_id, Model model ) {
        model.addAttribute("employee", serviceEmployee.findById(employee_id));
        model.addAttribute("Roles", Roles.values());
        return "/employeesUpdate";
    }
    @PutMapping("/employerUpdate/{employee_id}")
    public RedirectView updateEmployee(@PathVariable int employee_id, @ModelAttribute("empleado") Empleado empleado, Model model ){

        if ( serviceEmployee.findById( employee_id ) != null ){
            serviceEmployee.updateEmployee(empleado);
        }
        return new RedirectView("/usersEmployee");
    }



    @GetMapping("/movementsView")
    public String movementsView(Model model){
        ArrayList<MovimientoDinero> mov = (ArrayList<MovimientoDinero>) serviceMovement.getAllMovements();
        model.addAttribute("mov",mov);


        Long sumaMonto=serviceMovement.sumMounts();
        model.addAttribute("SumaMontos",sumaMonto);
        return "movement";
    }

//

    @GetMapping("/addMovements")
    public String nuevoMovimiento(Model model){

        model.addAttribute("mov",new MovimientoDinero());
//      model.addAttribute("mensaje",mensaje);
        //Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        //String correo=auth.getName();
//        Integer idEmpleado=movimiento.getUsuario().getEmployee_id();
//        model.addAttribute("idEmpleado",idEmpleado);
        return "saveMovement";
    }

    @PostMapping("/saveMovements")
    public RedirectView guardarMovimiento( @ModelAttribute MovimientoDinero mov,Model model){
//        if(serviceMovement.saveOrUpdateMovimiento(mov)){
//            redirectAttributes.addFlashAttribute("mensaje","saveOK");
//            return "redirect:/movementsView";
//        }
//        redirectAttributes.addFlashAttribute("mensaje","saveError");
//        return "redirect:/AgregarMovimiento";
//        if(result.hasErrors()) {
//            flash.addFlashAttribute("mensaje","saveOK");
//            return "redirect:/addMovement";
//        }
        model.addAttribute(mov);
        serviceMovement.saveOrUpdateMovimiento(mov);
        //String mensaje = (mov.getId() != null) ? "El movimiento ha sido editado con exito" : "Movimiento creado con exito";


//        status.setComplete();
//        flash.addFlashAttribute("success", mensaje);
        return new RedirectView("/movementsView");
    }

    @GetMapping("/updateMovement/{id}")
    public String editarMovimento(Model model, @PathVariable long id){
        MovimientoDinero mov=serviceMovement.getMovimientoById(id);

        model.addAttribute("mov",mov);
//        model.addAttribute("mensaje", mensaje);
//        List<Empleado> listaEmpleados= serviceEmployee.getEmployee();
//        model.addAttribute("emplelist",listaEmpleados);
        return "/updateMovements";
    }

    @PutMapping("/updateMovement/{id}")
    public RedirectView updateMovimiento(MovimientoDinero mov, @PathVariable long id, Model model){

            //redirectAttributes.addFlashAttribute("mensaje","Good");
            if ( serviceMovement.getMovimientoById( id ) != null ){
                serviceMovement.saveOrUpdateMovimiento(mov);

            }
            return new RedirectView("/movementsView");


//        redirectAttributes.addFlashAttribute("mensaje","ERROR");
       //return "redirect:/putMovement/"+mov.getId();

    }
//    @PutMapping("/employerUpdate/{employee_id}")
//    public RedirectView updateEmployee(@PathVariable int employee_id, @ModelAttribute("empleado") Empleado empleado, Model model ){
//        if ( serviceEmployee.findById( employee_id ) != null ){
//            serviceEmployee.updateEmployee(empleado);
//        }
//        return new RedirectView("/usersEmployee");
//    }

    @GetMapping("/deleteMovement/{id}")
    public String eliminarMovimiento(@PathVariable Long id, RedirectAttributes redirectAttributes){
        if (serviceMovement.deleteMovimiento(id)){
            //redirectAttributes.addFlashAttribute("mensaje","GOOD");
            return "redirect:/movementsView";
        }
        //redirectAttributes.addFlashAttribute("mensaje", "ERROR");
        return "redirect:/movementsView";
    }

//    @GetMapping("/employee/{id}/movements") //Filtro de movimientos por empleados
//    public String movimientosPorEmpleado(@PathVariable("id")Integer id, Model model){
//        List<MovimientoDinero> movlist = serviceMovement.getXEmplooye(id);
//        model.addAttribute("movlist",movlist);
//        Long sumaMonto=serviceMovement.mountsXEmplooye(id);
//        model.addAttribute("SumaMontos",sumaMonto);
//        return "movementsView"; //Llamamos al HTML
//    }
//
//    @GetMapping("/enterprises/{id}/movements") //Filtro de movimientos por empresa
//    public String movimientosPorEmpresa(@PathVariable("id")Integer id, Model model){
//        List<MovimientoDinero> movlist = serviceMovement.getXEnterprise(id);
//        model.addAttribute("movlist",movlist);
//        Long sumaMonto=serviceMovement.mountsXEnterprise(id);
//        model.addAttribute("SumaMontos",sumaMonto);
//        return "movementsView"; //Llamamos al HTML
//    }


}


