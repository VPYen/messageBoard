package javaSpring.Project.MessageBoardAPI.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import javaSpring.Project.MessageBoardAPI.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	List<User> findByNameContaining();
}
