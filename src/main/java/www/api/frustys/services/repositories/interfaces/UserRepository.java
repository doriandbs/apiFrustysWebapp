package www.api.frustys.services.repositories.interfaces;

import org.springframework.data.repository.CrudRepository;
import www.api.frustys.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {
}
