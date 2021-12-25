package org.learning.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "msg_from")
    private int msgFrom;

    @Column(name = "msg_to")
    private int msgTo;

    @Column(name = "message")
    private String msg;

    @Column(name = "msg_send_time")
    private LocalDateTime msgSendTime;

    public Message(int msgFrom, int msgTo, String msg){
        this.msgFrom=msgFrom;
        this.msgTo=msgTo;
        this.msg=msg;
    }


}
