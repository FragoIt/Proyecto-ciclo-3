package udea.techlogistics.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import udea.techlogistics.demo.entities.Empleado;
import udea.techlogistics.demo.entities.Empresa;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {


}
