package udea.techlogistics.demo.services;

import org.springframework.stereotype.Service;
import udea.techlogistics.demo.entities.Empresa;
import udea.techlogistics.demo.repositories.EmpresaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private EmpresaRepository repository;
    public EmpresaService(EmpresaRepository repository){
        this.repository = repository;
    }

    public List<Empresa> getEnterprise(){
        return this.repository.findAll();
    }
    public Empresa createEnterprise(Empresa newEmpresa){
        return this.repository.save(newEmpresa);
    }
    public Empresa findById(int enterprise_id ){
        Optional<Empresa> optDish = repository.findById( enterprise_id );
        if( optDish.isPresent()){
            return optDish.get();
        }
        return null;
    }
    public Empresa updateEnterprise( Empresa enterprise ){
        return repository.save( enterprise );
    }
    public void deleteEnterprise( Empresa enterprise ){
        repository.delete( enterprise );
    }
}
