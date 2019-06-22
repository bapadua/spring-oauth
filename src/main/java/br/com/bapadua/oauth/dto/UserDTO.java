package br.com.bapadua.oauth.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.bapadua.oauth.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	
	@NotBlank(message = "Informe o primeiro nome")
	private String firstName;
	
	@NotBlank(message = "Informe o segundo nome")
	private String lastName;
	
	@Email(message = "Informe um e-mail valido")
	private String email;

	public UserDTO() {
	}

	public UserDTO(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public UserDTO(String id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public User toUser() {
		return new User(firstName, lastName, email);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
