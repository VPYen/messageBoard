package javaSpring.Project.MessageBoardAPI.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import javaSpring.Project.MessageBoardAPI.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
	List<Message> findAll();
}
