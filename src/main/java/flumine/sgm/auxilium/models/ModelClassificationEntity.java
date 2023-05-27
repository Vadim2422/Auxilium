package flumine.sgm.auxilium.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="model_classifications")
public class ModelClassificationEntity {
    @Id
    protected Long id;

    @Column(name="model_name", unique=true, nullable=false)
    protected String name;

    @Column(name="model_available", nullable=false)
    protected boolean is_available;

    public ModelClassificationEntity() {}

    public ModelClassificationEntity(Long id, String name, boolean is_available) {
        this.id = id;
        this.name = name;
        this.is_available = is_available;
    }

    // Getters and setters

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

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }
}
