package flumine.sgm.auxilium.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class MessageModel {
    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column
    String role;

    @Column
    String content;

    @Column
    Long roomid;

    @Column
    Date date = new Date();

    public MessageModel(Long roomId, String role, String content) {
        roomid = roomId;
        this.role = role;
        this.content = content;
    }

    public MessageModel() {
    }

    @Override
    public String toString() {
        return "{" +
                "role:'" + role + '\'' +
                ", content:'" + content + '\'' +
                ", name:" + roomid +
                '}';
    }
}
