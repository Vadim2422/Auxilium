package flumine.sgm.auxilium.repositories;

import flumine.sgm.auxilium.models.ModelClassificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelClassificationRepository
        extends JpaRepository<ModelClassificationEntity, Long>
{

}
