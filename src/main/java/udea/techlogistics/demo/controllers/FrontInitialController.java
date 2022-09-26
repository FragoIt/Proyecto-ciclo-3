package udea.techlogistics.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import udea.techlogistics.demo.entities.Empleado;
import udea.techlogistics.demo.entities.Empresa;
import udea.techlogistics.demo.entities.MovimientoDinero;
import udea.techlogistics.demo.pagination.PageRender;
import udea.techlogistics.demo.repositories.MovimientoRepository;
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
//    @GetMapping({"/","/listar",""})
//    public String listarEmpleados(@RequestParam(name = "page",defaultValue = "0") int page,Model modelo) {
//        Pageable pageRequest = PageRequest.of(page, 4);
//        Page<Empleado> empleados = empleadoService.findAll(pageRequest);
//        PageRender<Empleado> pageRender = new PageRender<>("/listar", empleados);
//
//        modelo.addAttribute("titulo","Listado de empleados");
//        modelo.addAttribute("empleados",empleados);
//        modelo.addAttribute("page", pageRender);
//
//        return "listar";
//    }
//    @GetMapping ("/movementsView")
//    public String movementsView(Model model){
////        Pageable pageRequest = PageRequest.of(page, 4);
////        Page<MovimientoDinero> paginaMovimientos= serviceMovement.findAll(pageRequest);
////        PageRender<MovimientoDinero> pageRender = new PageRender<>("/movementsView", paginaMovimientos);
////        model.addAttribute("movlist",paginaMovimientos.getContent());
////        model.addAttribute("paginas",new int[paginaMovimientos.getTotalPages()]);
////        model.addAttribute("paginaActual", NumeroPagina);
////        model.addAttribute("mensaje",mensaje);
//        //model.addAttribute("titulo","Listado de movimientos");
////        model.addAttribute("movimientos",paginaMovimientos);
////        model.addAttribute("page", pageRender);
//        List<MovimientoDinero> movements = serviceMovement.getMovements();
//        model.addAttribute("movements",movements);

//        Long sumaMonto=serviceMovement.sumMounts();
//        model.addAttribute("SumaMontos",sumaMonto);//Mandamos la suma de todos los montos a la plantilla
//        return "movement"; //Llamamos al HTML
//    }
    @GetMapping("/Movements")
    public String movement(Model model){
        List<MovimientoDinero> movement = this.serviceMovement.getMovements();
        model.addAttribute("movement",movement);
        return "movement";
    }
//    @GetMapping("/addMovements")
//    public String nuevoMovimiento(Model model){
//        MovimientoDinero movimiento= new MovimientoDinero();
//        model.addAttribute("mov",movimiento);
////      model.addAttribute("mensaje",mensaje);
//        //Authentication auth= SecurityContextHolder.getContext().getAuthentication();
//        //String correo=auth.getName();
//        Integer idEmpleado=movimiento.getUsuario().getEmployee_id();
//        model.addAttribute("idEmpleado",idEmpleado);
//        return "saveMovement"; //Llamar HTML
//    }
//
//    @PostMapping("/saveMovement")
//    public String guardarMovimiento( MovimientoDinero mov,BindingResult result,Model model,RedirectAttributes flash,SessionStatus status){
////        if(serviceMovement.saveOrUpdateMovimiento(mov)){
////            redirectAttributes.addFlashAttribute("mensaje","saveOK");
////            return "redirect:/VerMovimientos";
////        }
////        redirectAttributes.addFlashAttribute("mensaje","saveError");
////        return "redirect:/AgregarMovimiento";
//        if(result.hasErrors()) {
//            flash.addFlashAttribute("mensaje","saveOK");
//            return "redirect:/addMovement";
//        }
//
//        String mensaje = (mov.getId() != null) ? "El movimiento ha sido editado con exito" : "Movimiento creado con exito";
//
//        serviceMovement.saveOrUpdateMovimiento(mov);
//        status.setComplete();
//        flash.addFlashAttribute("success", mensaje);
//        return "redirect:/movementsView";
//    }
//
//    @GetMapping("/putMovement/{id}")
//    public String editarMovimento(Model model, @PathVariable long id){
//        MovimientoDinero mov=serviceMovement.getMovimientoById(id);
//
//        model.addAttribute("mov",mov);
////        model.addAttribute("mensaje", mensaje);
//        List<Empleado> listaEmpleados= serviceEmployee.getEmployee();
//        model.addAttribute("emplelist",listaEmpleados);
//        return "updateMovements";
//    }
//
//    @PostMapping("/updateMovement")
//    public String updateMovimiento( RedirectAttributes redirectAttributes, MovimientoDinero mov,BindingResult result){
//        if(!result.hasErrors()){
//            redirectAttributes.addFlashAttribute("mensaje","Good");
//            return "redirect:/movementsView";
//        }
//
//        redirectAttributes.addFlashAttribute("mensaje","ERROR");
//        return "redirect:/putMovement/"+mov.getId();
//
//    }
//
//    @GetMapping("/deleteMovement/{id}")
//    public String eliminarMovimiento(@PathVariable Long id, RedirectAttributes redirectAttributes){
//        if (serviceMovement.deleteMovimiento(id)){
//            redirectAttributes.addFlashAttribute("mensaje","GOOD");
//            return "redirect:/movementsView";
//        }
//        redirectAttributes.addFlashAttribute("mensaje", "ERROR");
//        return "redirect:/movementsView";
//    }

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
//

}


