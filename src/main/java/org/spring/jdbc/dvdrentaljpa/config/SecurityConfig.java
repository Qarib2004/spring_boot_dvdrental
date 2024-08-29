package org.spring.jdbc.dvdrentaljpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/hello").permitAll() // Доступ без аутентификации
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // Используем HTTP Basic аутентификацию

        return http.build();
    }
}
