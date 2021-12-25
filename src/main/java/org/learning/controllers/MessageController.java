package org.learning.controllers;

import org.learning.assemblers.DomainAssembler;
import org.learning.assemblers.DtoAssembler;
import org.learning.dtos.CreateUserDto;
import org.learning.dtos.MessageDto;
import org.learning.dtos.SendMessageDto;
import org.learning.dtos.UserDto;
import org.learning.entities.Message;
import org.learning.entities.User;
import org.learning.services.MessageService;
import org.learning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    private DomainAssembler domainAssembler;

    private DtoAssembler dtoAssembler;

    @GetMapping
    public ResponseEntity<?> getAllMessages() throws Exception {
        List<Message> msgList=messageService.getAllMessages();
        List<MessageDto> msgDtos=dtoAssembler.getMessageDtoListFromMessageDomainList(msgList);
        return ResponseEntity.ok(msgDtos);
    }

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody SendMessageDto sendMessageDto) {
        Message message=domainAssembler.getMessageFromSendMessageDto(sendMessageDto);
        messageService.sendMessage(message);
        return ResponseEntity.accepted().build();
    }
}
