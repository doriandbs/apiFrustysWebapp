package www.api.frustys.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import www.api.frustys.entities.UtilisateurEntity;

@Repository
public interface IUserRepository extends JpaRepository<UtilisateurEntity,Long> {
    UtilisateurEntity findFirstByEmail(String email);
}
