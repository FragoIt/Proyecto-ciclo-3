package udea.techlogistics.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.techlogistics.demo.entities.MovimientoDinero;

import udea.techlogistics.demo.repositories.MovimientoRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoServices {
    @Autowired
    MovimientoRepository MovimientoRepository;


    public MovimientoServices(MovimientoRepository MovimientoRepository){
        this.MovimientoRepository = MovimientoRepository;
    }
    public List<MovimientoDinero> getAllMovimientos(){ //Metodo que me muestra todos los movimientos sin ningn filtro
//        List<MovimientoDinero> movimientosList = new ArrayList<>();
//        MovimientoRepository.findAll().forEach(movimiento -> movimientosList.add(movimiento));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return MovimientoRepository.findAll();
    }

    public MovimientoDinero getMovimientoById(Long id){ //Ver movimientos por id
        return MovimientoRepository.findById(id).get();
    }

    public MovimientoDinero saveOrUpdateMovimiento(MovimientoDinero movimientoDinero){ //Guardar o actualizar elementos
        MovimientoDinero mov=MovimientoRepository.save(movimientoDinero);
        return mov;
    }

    public boolean deleteMovimiento(Long id){
        MovimientoRepository.deleteById(id);
        if(this.MovimientoRepository.findById(id).isPresent()){
            return false;
        }

        return true; //Si al buscar el movimiento no lo encontramos, si lo eliminò (true)
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id) { //Obterner teniendo en cuenta el id del empleado
        return MovimientoRepository.findByEmpleado(id);
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id) { //Obtener movimientos teniendo en cuenta el id de la empresa a la que pertencen los empleados que la registraron
        return MovimientoRepository.findByEmpresa(id);
    }
}
