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
    String role;

    @Column
    Long UserID;


    public RoomModel(String role, Long userID) {
        this.role = role;
        UserID = userID;
    }

    public RoomModel(RoomModel model) {
        this.role = model.role;
        UserID = model.UserID;
    }

    public RoomModel() {

    }
}