package flumine.sgm.auxilium.repositories;

import flumine.sgm.auxilium.models.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel,Long> {
    List<MessageModel> findAllByRoomid(Long roomid);

    void deleteAllByRoomid(Long roomid);
}
