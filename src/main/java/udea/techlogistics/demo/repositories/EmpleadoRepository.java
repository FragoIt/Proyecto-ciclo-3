package udea.techlogistics.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udea.techlogistics.demo.entities.Empleado;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
