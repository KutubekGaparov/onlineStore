package online;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.AllArgsConstructor;
import online.db.model.enums.ERole;
import online.db.model.enums.Role;
import online.db.model.User;
import online.db.repository.RoleRepository;
import online.db.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@SpringBootApplication
@OpenAPIDefinition
@AllArgsConstructor
public class OnlineStoreApplication {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(OnlineStoreApplication.class, args);
        System.out.println("Welcome to application online store");
    }

    @GetMapping("/")
    public String getAllBookRequest() {
        return " Hello Barsbek2";
    }


    @PostConstruct
    public void init() {
        Role client = new Role();
        client.setId(1L);
        client.setName(ERole.ROLE_ADMIN);
        Role admin = new Role();
        admin.setId(2L);
        admin.setName(ERole.ROLE_CLIENT);
        roleRepository.save(client);
        roleRepository.save(admin);

        User c = new User();
        c.setEmail("admin@gmail.com");
        c.setFullName("Admin");
        c.setPassword(encoder.encode("admin"));
        c.setRole(roleRepository.getByIdRole(1L));
        userRepository.save(c);
        User a = new User();
        a.setEmail("client@gmail.com");
        a.setFullName("Client");
        a.setPassword(encoder.encode("client"));
        a.setRole(roleRepository.getByIdRole(2L));

        userRepository.save(a);
    }
}
