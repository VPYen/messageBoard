package javaSpring.Project.MessageBoardAPI;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaSpring.Project.MessageBoardAPI.models.User;
import javaSpring.Project.MessageBoardAPI.models.Thread;
import javaSpring.Project.MessageBoardAPI.models.Message;
import javaSpring.Project.MessageBoardAPI.services.UserService;
import javaSpring.Project.MessageBoardAPI.services.ThreadService;
import javaSpring.Project.MessageBoardAPI.services.MessageService;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/messageAPI/")
public class MessageBoardAPI {
	private final UserService userService;
	private final ThreadService threadService;
	private final MessageService messageService;
	
	public MessageBoardAPI(MessageService messageService, ThreadService threadService, UserService userService) {
		this.messageService = messageService;
		this.threadService = threadService;
		this.userService = userService;
	}
	
	// Return all users
	@RequestMapping("/user")
	public List<User> getUsers() {
		return userService.allUsers();
	}
	
	// Create new user
	@PostMapping("/user/new")
	public User newUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	// Return all threads
	@RequestMapping("/thread")
	public List<Thread> getThreads() {
		return threadService.allThreads();
	}
	
	// Return thread by id
	@RequestMapping("/thread/{id}")
	public Thread threadById(@PathVariable("id") Long id) {
		return threadService.threadById(id);
	}
	
	// Create new thread
	@PostMapping("/thread/new")
	public Thread newThread(@RequestBody Thread thread) {
		return threadService.createThread(thread);
	}
	
	// Post message to thread
	@PutMapping("/thread/{id}/message")
	public Thread newMessage(@PathVariable("id") Long id, @RequestBody Message message) {
		Thread thread = threadService.threadById(id);
		if(thread != null) {
			message.setThread(thread);
			messageService.createMsg(message);
		}
		
		return thread;
	}
}