package javaSpring.Project.MessageBoardAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import javaSpring.Project.MessageBoardAPI.models.Thread;
import javaSpring.Project.MessageBoardAPI.repositories.ThreadRepository;

@Service
public class ThreadService {
	private final ThreadRepository threadRepo;
	
	public ThreadService(ThreadRepository threadRepo) {
		this.threadRepo = threadRepo;
	}
	
	// Retrieve all threads
	public List<Thread> allThreads() {
		return threadRepo.findAll();
	}
	
	// Retrieve by id
	public Thread threadById(Long id) {
		Optional<Thread> optionalThread = threadRepo.findById(id);
		
		if(optionalThread.isPresent()) {
			return optionalThread.get();
		}
		return null;
	}
	
	// Create Thread
	public Thread createThread(Thread thread) {
		return threadRepo.save(thread);
	}
	
	// Delete a thread
	public void deleteEventById(Long id) {
		Optional<Thread> optionalThread =  threadRepo.findById(id);
		
		if(optionalThread.isPresent()) {
			threadRepo.deleteById(id);
		}
	}
}
