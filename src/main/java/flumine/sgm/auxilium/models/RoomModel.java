package flumine.sgm.auxilium.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class RoomModel {

    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column
    String name;

    @Column
    String role;

    @Column
    Long userid;


    public RoomModel(String role, Long userid) {
        this.role = role;
        this.userid = userid;
    }

    public RoomModel(RoomModel model) {
        this.name = model.name;
        this.role = model.role;
        userid = model.userid;
    }

    public RoomModel() {

    }
}
