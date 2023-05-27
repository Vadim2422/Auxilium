package flumine.sgm.auxilium.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/** Model which indicates all available models.
  * 
  */
@Entity
@Table(name="ai_models")
public class ModelEntity {
    @Id
    @GeneratedValue
    @Column
    protected Long id;

    @Column(
        unique=true,
        nullable=false)
    protected String name;

    @Column(
        nullable=false
    )
    protected String origin_name;

    public ModelEntity() {}

    public ModelEntity(Long id, String name, String origin_name) {
        this.id = id;
        this.name = name;
        this.origin_name = origin_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }
    
    
}
