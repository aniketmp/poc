package org.learning.assemblers;

import org.learning.dtos.MessageDto;
import org.learning.dtos.SendMessageDto;
import org.learning.dtos.UserDto;
import org.learning.entities.Message;
import org.learning.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoAssembler {
    public static List<UserDto> getUserDtoListFromUserDomainList(List<User> userList) {
        List<UserDto> dtoList=new ArrayList<>();
        userList.forEach( user -> dtoList.add(new UserDto(user.getUserName(),user.getPassword(),user.getRole())));
        return dtoList;
    }
    private static UserDto getUserDtoFromUserDomain(User user)
    {
        return new UserDto(user.getUserName(),user.getPassword(),user.getRole());
    }

    public List<MessageDto> getMessageDtoListFromMessageDomainList(List<Message> msgList) {
        List<MessageDto> messageDtos=new ArrayList<>();
        msgList.forEach(
                message -> messageDtos.add(new MessageDto(message.getMsgFrom(),message.getMsgTo(),message.getMsg(),message.getMsgSendTime()))
        );
        return messageDtos;
    }
}
