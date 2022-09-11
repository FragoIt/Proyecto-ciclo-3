package udea.techlogistics.demo.controllers;

import org.springframework.web.bind.annotation.*;
import udea.techlogistics.demo.entities.Empresa;
import udea.techlogistics.demo.services.EmpresaService;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EmpresaController {
    private EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Empresa> Enterprise(){
        return this.service.getEnterprise();
    }
    @PostMapping
    public Empresa createEnterprise(@RequestBody Empresa empresa){
        return this.service.createEnterprise(empresa);
    }
    @GetMapping("/{enterprise_id}")
    public Empresa findById(@PathVariable int enterprise_id ){
        return service.findById( enterprise_id );
    }
    @PutMapping("/{enterprise_id}")
    public Empresa updateEnterprise(@RequestBody Empresa empresa ){
        if ( service.findById( empresa.getEnterprise_id() ) != null ){
            return service.updateEnterprise( empresa );
        }
        return null;
    }
    @DeleteMapping("/{enterprise_id}")
    public Empresa deleteEnterprise( @PathVariable int enterprise_id ){
        Empresa enterprise = service.findById( enterprise_id );
        if( enterprise != null){
            service.deleteEnterprise( enterprise );
            return enterprise;
        }
        return null;
    }
}
