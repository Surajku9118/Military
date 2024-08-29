package admin_user.LoginSingup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .requestMatchers("/","/signup","/login", "/about", "/store/**", "/apply", "/donate", "/help", "/home", "/resources", "/register","/memorials").permitAll()
            .requestMatchers("/images/**", "/css/**", "/js/**").permitAll() // Allow access to static resources
            .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/") // Adjust this URL as needed
                .failureUrl("/login?error=true")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout=true");

        return http.build();
    }
}