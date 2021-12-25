package org.learning.services;

import org.learning.entities.Message;
import org.learning.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public List<Message> getAllMessages()
    {
        return messageRepo.findAll();
    }

    public void sendMessage(Message message) {
        messageRepo.save(message);
    }
}
