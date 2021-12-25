package org.learning.dtos;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class MessageDto {

    private int msgFrom;
    private int msgTo;
    private String msg;
    private LocalDateTime msgSendTime;

    public MessageDto(int msgFrom, int msgTo, String msg,LocalDateTime msgSendTime){
        this.msgFrom=msgFrom;
        this.msgTo=msgTo;
        this.msg=msg;
        this.msgSendTime=msgSendTime;
    }

}
