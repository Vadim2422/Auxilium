package flumine.sgm.auxilium.repositories;

import flumine.sgm.auxilium.models.MessageAIModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageAIRepository extends JpaRepository<MessageAIModel, Long> {
    List<MessageAIModel> findAllByRoomID(Long room_id);

    void deleteAllByRoomID(Long room_id);
}
