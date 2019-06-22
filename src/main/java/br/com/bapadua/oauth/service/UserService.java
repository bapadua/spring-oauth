package br.com.bapadua.oauth.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.bapadua.oauth.domain.Role;
import br.com.bapadua.oauth.domain.User;
import br.com.bapadua.oauth.dto.UserDTO;

public interface UserService {
	
	ResponseEntity<UserDTO> findUserByEmail(String email);

	ResponseEntity<List<UserDTO>> findAll();

	ResponseEntity<UserDTO> save(User user);

	ResponseEntity<UserDTO> findById(String id);
	
	ResponseEntity<UserDTO> update(UserDTO user);

	ResponseEntity<HttpStatus> delete(String id);
	
	ResponseEntity<List<Role>> findRolesById(String id);

}
