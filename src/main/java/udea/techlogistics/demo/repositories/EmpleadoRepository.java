package udea.techlogistics.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import udea.techlogistics.demo.entities.Empleado;
import udea.techlogistics.demo.entities.Empresa;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    //@Query(value="SELECT * FROM employee where id_empresa= ?1", nativeQuery=true)
    //public abstract ArrayList<Empleado> findByEmpresa(Integer id);

    //Empleados de una empresa
    @Query(value = "select empleado from Empleado empleado where empleado.enterprise.enterprise_id=:id")
    List<Empleado> getEmployeeEnterprise( int id);

    //@Query(value = "select enterprise from Empresa enterprise where enterprise.enterprise_id =: id")
    //boolean findEnterpriseById( int id );

}
