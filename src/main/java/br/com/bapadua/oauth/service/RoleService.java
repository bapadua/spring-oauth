package br.com.bapadua.oauth.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.bapadua.oauth.domain.Role;

public interface RoleService {

	ResponseEntity<List<Role>> findAll();

	ResponseEntity<Role> save(Role role);

	ResponseEntity<Role> findById(String id);
	
	ResponseEntity<Role> update(Role role);

	ResponseEntity<HttpStatus> delete(String id);

}
