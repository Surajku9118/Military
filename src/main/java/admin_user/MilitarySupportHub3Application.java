package admin_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = "admin_user.LoginSingup")
@EntityScan(basePackages = "admin_user.LoginSingup")
@EnableJpaRepositories(basePackages = "admin_user.LoginSingup")
public class MilitarySupportHub3Application {

    public static void main(String[] args) {
        SpringApplication.run(MilitarySupportHub3Application.class, args);
    }
}

