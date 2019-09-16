package javaSpring.Project.MessageBoardAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import javaSpring.Project.MessageBoardAPI.models.Message;
import javaSpring.Project.MessageBoardAPI.repositories.MessageRepository;

@Service
public class MessageService {
	private final MessageRepository msgRepo;
	
	public MessageService(MessageRepository msgRepo) {
		this.msgRepo = msgRepo;
	}
	
	// Retrieve all messages
	public List<Message> allMsg() {
		return msgRepo.findAll();
	}
	
	// Retrieve by id
	public Message threadById(Long id) {
		Optional<Message> optionalMsg = msgRepo.findById(id);
		
		if(optionalMsg.isPresent()) {
			return optionalMsg.get();
		}
		return null;
	}
	
	// Create Message
	public Message createMsg(Message msg) {
		return msgRepo.save(msg);
	}
	
	// Delete a message
	public void deleteMsgById(Long id) {
		Optional<Message> optionalMessage =  msgRepo.findById(id);
		
		if(optionalMessage.isPresent()) {
			msgRepo.deleteById(id);
		}
	}
}
