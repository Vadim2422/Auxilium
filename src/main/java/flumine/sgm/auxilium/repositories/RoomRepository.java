package flumine.sgm.auxilium.repositories;

import flumine.sgm.auxilium.models.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Long> {


}
