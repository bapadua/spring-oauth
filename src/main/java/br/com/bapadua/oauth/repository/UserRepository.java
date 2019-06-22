package br.com.bapadua.oauth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.bapadua.oauth.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> findUserByEmail(String email);

	Optional<User> findById(String id);
	
}
	