package udea.techlogistics.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.techlogistics.demo.entities.MovimientoDinero;
import udea.techlogistics.demo.services.MovimientoServices;


import java.util.ArrayList;
import java.util.List;
@RestController
public class MovimientoController {

    @Autowired
    MovimientoServices movimientosService;

    @GetMapping("/movimientos")
    public List<MovimientoDinero> verMovimientos(){
        return movimientosService.getAllMovements();
    }

    @PostMapping("/movimientos")
    public MovimientoDinero guardarMovimiento(@RequestBody  MovimientoDinero movimiento){
        return movimientosService.saveOrUpdateMovimiento(movimiento);
    }

    @GetMapping("/movimientos/{id}")
    public ResponseEntity<MovimientoDinero> movimientoPorId(@PathVariable("id") Long id){
        try {
            MovimientoDinero move= movimientosService.getMovimientoById(id);
            return new ResponseEntity<MovimientoDinero>(move, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<MovimientoDinero>(HttpStatus.NOT_FOUND); }
        }

    @PatchMapping("/movimientos/{id}")
    public MovimientoDinero actualizarMovimiento(@PathVariable("id") Long id, @RequestBody MovimientoDinero movimiento){
        MovimientoDinero mov=movimientosService.getMovimientoById(id);
        mov.setConcept(movimiento.getConcept());
        mov.setAmount(movimiento.getAmount());
        mov.setUsuario(movimiento.getUsuario());
        return movimientosService.saveOrUpdateMovimiento(mov);
    }

    @DeleteMapping("/movimientos/{id}")
    public void  deleteMovimiento(@PathVariable("id") Long id){
        boolean respuesta= movimientosService.deleteMovimiento(id);

    }

    @GetMapping("/employee/{id}/movimientos") //Consultar movimientos por id del empleado
    public ArrayList<MovimientoDinero> movimientosPorEmpleado(@PathVariable("id") Integer id){
        return movimientosService.getXEmplooye(id);
    }

    @GetMapping("/enterprise/{id}/movimientos") //Consultar movimientos que pertenecen a una empresa por el id de la empresa
    public ArrayList<MovimientoDinero> movimientosPorEmpresa(@PathVariable("id") Integer id){
        return movimientosService.getXEnterprise(id);
    }
}
