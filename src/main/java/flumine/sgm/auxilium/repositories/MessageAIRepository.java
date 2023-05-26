package flumine.sgm.auxilium.repositories;

import flumine.sgm.auxilium.models.MessageAIModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageAIRepository extends JpaRepository<MessageAIModel, Long> {
}
