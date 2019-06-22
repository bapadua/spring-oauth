package br.com.bapadua.oauth.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bapadua.oauth.domain.Role;
import br.com.bapadua.oauth.dto.UserDTO;
import br.com.bapadua.oauth.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable(name = "id") String id) {
		return userService.findById(id);
	}
	
	@GetMapping("/{id}/roles")
	public ResponseEntity<List<Role>> findRolesById(@PathVariable(name = "id") String id) {
		return userService.findRolesById(id);
	}

	@GetMapping("/search/email")
	public ResponseEntity<UserDTO> getByEmail(@RequestParam(value = "email") String email) {
		return userService.findUserByEmail(email);
	}

	@PutMapping
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO dto) {
		return userService.update(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") String id) {
		return userService.delete(id);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid UserDTO data) {
		return userService.save(data.toUser());
	}

}
