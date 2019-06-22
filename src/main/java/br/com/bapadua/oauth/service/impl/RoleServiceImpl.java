package br.com.bapadua.oauth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.bapadua.oauth.domain.Role;
import br.com.bapadua.oauth.repository.RoleRepository;
import br.com.bapadua.oauth.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository repository;

	@Override
	public ResponseEntity<List<Role>> findAll() {
		List<Role> list = repository.findAll();
		
		if(list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@Override
	public ResponseEntity<Role> save(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Role> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Role> update(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<HttpStatus> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
