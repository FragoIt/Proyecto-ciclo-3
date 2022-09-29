package udea.techlogistics.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import udea.techlogistics.demo.entities.MovimientoDinero;

import udea.techlogistics.demo.repositories.MovimientoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoServices {
    @Autowired
    MovimientoRepository MovimientoRepository;

//
//    //public Page<MovimientoDinero> findAll(Pageable pageable){
//        return MovimientoRepository.findAll(pageable);
//    }

    public MovimientoServices(MovimientoRepository MovimientoRepository){
        this.MovimientoRepository = MovimientoRepository;
    }

    public List<MovimientoDinero> getAllMovements(){
        return this.MovimientoRepository.findAll();
    }
//    public List<MovimientoDinero> getMovements(){
//        return this.MovimientoRepository.findAll();
//    }

    public MovimientoDinero getMovimientoById(Long id){ //Ver movimientos por id
        return MovimientoRepository.findById(id).get();
    }

    public MovimientoDinero saveOrUpdateMovimiento(MovimientoDinero movimientoDinero){
        MovimientoDinero mov=MovimientoRepository.save(movimientoDinero);
        return mov;
    }

    public boolean deleteMovimiento(Long id){
        MovimientoRepository.deleteById(id);
        if(this.MovimientoRepository.findById(id).isPresent()){
            return true;
        }

        return false;
    }

    public ArrayList<MovimientoDinero> getXEmplooye(Integer id) {
        return MovimientoRepository.findByEmplooye(id);
    }

    public ArrayList<MovimientoDinero> getXEnterprise(Integer id) {
        return MovimientoRepository.findByEmpresa(id);
    }


    public Long sumMounts(){
        return MovimientoRepository.SumarMonto();
    }


    public Long mountsXEmplooye(Integer id){
        return MovimientoRepository.mountXEmplooyes(id);
    }


    public Long mountsXEnterprise(Integer id){
        return MovimientoRepository.mountXEnterprise(id);
    }

    public int IdPorCorreo(String email){
        return MovimientoRepository.idXEmail(email);
    }



}
