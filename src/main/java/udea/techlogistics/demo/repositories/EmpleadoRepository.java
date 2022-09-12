package udea.techlogistics.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import udea.techlogistics.demo.entities.Empleado;

import java.util.ArrayList;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    @Query(value="SELECT * FROM employee where id_empresa= ?1", nativeQuery=true)
    public abstract ArrayList<Empleado> findByEmpresa(Integer id);
}
