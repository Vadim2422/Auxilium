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



}
