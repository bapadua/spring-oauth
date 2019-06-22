package br.com.bapadua.oauth;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bapadua.oauth.domain.Role;
import br.com.bapadua.oauth.domain.User;
import br.com.bapadua.oauth.repository.RoleRepository;
import br.com.bapadua.oauth.repository.UserRepository;

@SpringBootApplication
public class BapaduaOauthApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(BapaduaOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		roleRepository.deleteAll();

		Role adminRole = roleRepository.save(new Role("ROLE_ADMIN"));
		Role userRole = roleRepository.save(new Role("ROLE_USER"));

		User user = new User("Bruno", "Padua", "bapadua@outlook.com");
		user.setRoles(Arrays.asList(adminRole, userRole));

		startUser(user);

		roleRepository.save(userRole);
		
	}

	private User startUser(final User user) {
		Optional<User> result = userRepository.findUserByEmail(user.getEmail());
		if (result.isPresent()) {
			return result.get();
		}
		return userRepository.save(user);
	}

}
