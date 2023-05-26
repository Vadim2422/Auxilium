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
    String content;

    @Column
    Long RoomID;

    @Column
    Date date;

    public MessageAIModel(String content, Long roomID, Date date) {
        this.content = content;
        RoomID = roomID;
        this.date = date;
    }
    //{"role": "user", "content": "Hello!"}
    //TODO: toString
}
