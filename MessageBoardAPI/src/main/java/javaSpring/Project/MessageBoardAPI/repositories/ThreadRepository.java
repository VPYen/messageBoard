package javaSpring.Project.MessageBoardAPI.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import javaSpring.Project.MessageBoardAPI.models.Thread;

public interface ThreadRepository extends CrudRepository<Thread, Long> {
	List<Thread> findAll();
	List<Thread> findByTitleContaining(String title);
	List<Thread> findByAuthorContaining(String author);
}
