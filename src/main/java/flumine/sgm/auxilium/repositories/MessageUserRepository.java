package flumine.sgm.auxilium.repositories;

import flumine.sgm.auxilium.models.MessageUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageUserRepository extends JpaRepository<MessageUserModel, Long> {
}
