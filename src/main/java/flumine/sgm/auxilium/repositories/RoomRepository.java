package flumine.sgm.auxilium.repositories;

import flumine.sgm.auxilium.models.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Long> {
    Optional<RoomModel> findById(Long room_id);


}
