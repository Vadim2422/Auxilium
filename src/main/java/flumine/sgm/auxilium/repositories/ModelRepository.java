package flumine.sgm.auxilium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import flumine.sgm.auxilium.models.ModelEntity;


public interface ModelRepository extends JpaRepository<ModelEntity, Long> 
{
}
