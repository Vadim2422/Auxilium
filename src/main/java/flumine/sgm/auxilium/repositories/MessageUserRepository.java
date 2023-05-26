package flumine.sgm.auxilium.repositories;

import flumine.sgm.auxilium.models.MessageUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageUserRepository extends JpaRepository<MessageUserModel, Long> {
    List<MessageUserModel> findAllByRoomID(Long room_id);

    void deleteAllByRoomID(Long room_id);
}
