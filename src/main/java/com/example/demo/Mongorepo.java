package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mongorepo extends MongoRepository<User,String> {

	User findByEmail(String eMAIL);
	
	List<User> findByAgeGreaterThan(int a);

	List<User> findByAgeLessThan(int a);
	
	List<User> findByAgeBetween(int from, int to);

	List<User> findByNameNotNull();

	List<User> findByNameNull();

	List<User> findByNameLike(String name);

	List<User> findByNameRegex(String name);

	List<User> findByNameNot(String name);

	List<User> findByNameAndAge(String name, int age);

	List<User> findByNameOrAge(String name, int age);

	Boolean existsByEmail(String email);
	
	Boolean existsByUsername(String user);

    User findByUsername(String username);
}