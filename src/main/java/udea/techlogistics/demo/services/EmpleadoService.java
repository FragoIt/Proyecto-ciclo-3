package udea.techlogistics.demo.services;

import org.springframework.stereotype.Service;
import udea.techlogistics.demo.entities.Empleado;
import udea.techlogistics.demo.repositories.EmpleadoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    private EmpleadoRepository repository;
    public EmpleadoService(EmpleadoRepository repository){
        this.repository = repository;
    }

    public List<Empleado> getEmployee(){
        return this.repository.findAll();
    }
    public Empleado createEmpleado(Empleado newEmpleado){
        return this.repository.save(newEmpleado);
    }
    public Empleado findById(int employee_id ){
        Optional<Empleado> optDish = repository.findById( employee_id );
        if( optDish.isPresent()){
            return optDish.get();
        }
        return null;
    }
    public Empleado updateEmployee( Empleado employee ){
        return repository.save( employee );
    }
    public void deleteEmployee( Empleado employee ){
        repository.delete( employee );
    }

    public List<Empleado> getEmployeeEnterprise(int id){
        return repository.getEmployeeEnterprise( id );
    }
}

