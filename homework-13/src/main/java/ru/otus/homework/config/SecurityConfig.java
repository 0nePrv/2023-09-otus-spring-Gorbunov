package ru.otus.homework.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(@NonNull HttpSecurity http) throws Exception {
    return http
        .csrf(withDefaults())
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/login", "/css/**").permitAll()
            .requestMatchers("/", "/book").hasAnyRole("GUEST", "USER", "ADMIN")
            .requestMatchers("/book/**").hasAnyRole("USER", "ADMIN")
            .requestMatchers("/author/**", "/genre/**").hasRole("ADMIN")
            .anyRequest().denyAll())
        .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
        .rememberMe(rm -> rm.tokenValiditySeconds(1800))
        .formLogin(formLogin -> formLogin.loginPage("/login").permitAll())
        .exceptionHandling(exception -> exception.accessDeniedPage("/login?accessDenied"))
        .logout(LogoutConfigurer::permitAll)
        .getOrBuild();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
