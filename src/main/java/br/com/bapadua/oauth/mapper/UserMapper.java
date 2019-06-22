package br.com.bapadua.oauth.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bapadua.oauth.domain.User;
import br.com.bapadua.oauth.dto.UserDTO;

@Service
public class UserMapper {
	
	public UserDTO toDTO(User user) {
		
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		
		return dto;
	}
	
	public List<UserDTO> toDTOList(List<User> list) {
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		list.forEach(entity -> {
			UserDTO dto = new UserDTO();
			dto.setId(entity.getId());
			dto.setEmail(entity.getEmail());
			dto.setFirstName(entity.getFirstName());
			dto.setLastName(entity.getLastName());	
			dtos.add(dto);
		});
		return dtos;
	}
}
