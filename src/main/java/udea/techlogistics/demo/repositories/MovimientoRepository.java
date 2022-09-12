package udea.techlogistics.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import udea.techlogistics.demo.entities.MovimientoDinero;

import java.util.ArrayList;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoDinero, Long> {
    @Query(value ="select * from movimientos where empleado_id= ?1", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpleado(Integer id);

    @Query(value="select * from movimientos where empleado_id in (select id from empleado where empresa_id= ?1)", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Integer id);
}
