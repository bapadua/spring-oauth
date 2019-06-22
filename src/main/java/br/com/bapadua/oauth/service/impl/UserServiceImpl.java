package br.com.bapadua.oauth.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.bapadua.oauth.domain.Role;
import br.com.bapadua.oauth.domain.User;
import br.com.bapadua.oauth.dto.UserDTO;
import br.com.bapadua.oauth.exceptions.ObjectNotFoundException;
import br.com.bapadua.oauth.mapper.UserMapper;
import br.com.bapadua.oauth.repository.UserRepository;
import br.com.bapadua.oauth.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	public Optional<User> findByUserId(String id) {
		return userRepository.findById(id);
	}

	@Override
	public ResponseEntity<UserDTO> save(User user) {
		/**
		 * Verifica se o e-mail cadastrado já existe
		 */
		Optional<User> result = userRepository.findUserByEmail(user.getEmail());
		if (result.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(userMapper.toDTO(result.get()));
		}

		/**
		 * Salva o documento
		 */
		User save = userRepository.save(user);
		return ResponseEntity.status(HttpStatus.OK).body(userMapper.toDTO(save));
	}

	@Override
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(userMapper.toDTOList(userRepository.findAll()));
	}

	public ResponseEntity<UserDTO> findUserByEmail(String email) {
		Optional<User> result = userRepository.findUserByEmail(email);
		result.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
		return ResponseEntity.status(HttpStatus.OK).body(userMapper.toDTO(result.get()));
	}

	@Override
	public ResponseEntity<UserDTO> findById(String id) {
		Optional<User> result = userRepository.findById(id);
		result.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado: id -> " + id));
		return ResponseEntity.status(HttpStatus.OK).body(userMapper.toDTO(result.get()));
	}

	@Override
	public ResponseEntity<UserDTO> update(UserDTO user) {
		Optional<User> result = userRepository.findById(user.getId());
		User update = result
				.map(u -> userRepository
						.save(new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail())))
				.orElseThrow(() -> new ObjectNotFoundException("Usuário inválido"));

		return ResponseEntity.status(HttpStatus.OK).body(userMapper.toDTO(update));
	}

	@Override
	public ResponseEntity<HttpStatus> delete(String id) {
		userRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@Override
	public ResponseEntity<List<Role>> findRolesById(String id) {
		Optional<User> result = userRepository.findById(id);
		result.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
		User user = result.get();
		return ResponseEntity.status(HttpStatus.OK).body(user.getRoles());
	}

}
