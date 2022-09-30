package udea.techlogistics.demo.repositories;

import org.springframework.stereotype.Repository;
import udea.techlogistics.demo.entities.Empleado;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<Empleado, Integer> {
    Empleado findByUsers(String users);
}
