package org.learning.assemblers;

import org.learning.dtos.CreateUserDto;
import org.learning.dtos.SendMessageDto;
import org.learning.entities.Message;
import org.learning.entities.User;
import org.springframework.stereotype.Component;

@Component
public class DomainAssembler {
    public User getUserFromCreateUserDto(CreateUserDto createUserDto) {
        return new User(createUserDto.getUserName(),createUserDto.getPassword(),createUserDto.getRole());
    }

    public Message getMessageFromSendMessageDto(SendMessageDto sendMessageDto) {
        return null;
    }
}
