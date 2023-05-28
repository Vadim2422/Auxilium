package flumine.sgm.auxilium.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class MessageModel {
    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column
    @Enumerated(EnumType.STRING)
    MessageRole role;

    @Column
    String content;

    @Column
    Long roomid;

    @Column
    Date date = new Date();

    public MessageModel(MessageRole role, String content, Long roomid) {
        this.role = role;
        this.content = content;
        this.roomid = roomid;
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
