package udea.techlogistics.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import udea.techlogistics.demo.entities.Empresa;
import udea.techlogistics.demo.services.EmpresaService;

@RestController
public class EmpresaController {
    EmpresaService service;

    public EmpresaController() {
        this.service = new EmpresaService();
    }

    @GetMapping("/enterprise")
    public Empresa Enterprise(){
        return this.service.getEnterprise();
    }
}
