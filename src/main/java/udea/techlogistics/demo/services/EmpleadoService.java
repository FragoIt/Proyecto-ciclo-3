package udea.techlogistics.demo.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import udea.techlogistics.demo.entities.Empleado;
import udea.techlogistics.demo.repositories.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    PasswordEncoder passwordEncoder;
    private EmpleadoRepository repository;
    public EmpleadoService(EmpleadoRepository repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Empleado> getEmployee(){
        return this.repository.findAll();
    }
    public Empleado createEmpleado(Empleado newEmpleado){
        String encodedPassword = this.passwordEncoder.encode(newEmpleado.getPassword());
        newEmpleado.setPassword(encodedPassword);
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
        String encodedPassword = this.passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        return repository.save( employee );
    }
    public void deleteEmployee( Empleado employee ){
        repository.delete( employee );
    }


    public List<Empleado> getEmployeeEnterprise(int id){
        return repository.getEmployeeEnterprise( id );
    }
}

