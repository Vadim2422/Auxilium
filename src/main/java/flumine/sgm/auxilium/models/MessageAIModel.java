package flumine.sgm.auxilium.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class MessageAIModel {
    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column
    Long RoomID;

    @Column
    Date date;

}
