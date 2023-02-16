package com.example.hitoprueba;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity  {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UsuarioDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Filtros por URL.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests()
                // Recursos estáticos que no requieren autentificación.
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/images/**").permitAll()
                // No se requiere autenticación para acceso a la raiz y al login
                .requestMatchers("/", "/login").permitAll()
                // Solo puede acceder el ADMINISTRADOR
                .requestMatchers("/admin/**").hasAuthority("admin")
                // Solo puede acceder el USUARIO
                .requestMatchers("/user/**").hasAnyAuthority("usuario", "admin")
                // Se requiere autenticación para el resto de reutas.
                .anyRequest().authenticated()
                // Se permite iniciar y cerrar sesión.
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll()
                // Error permiso denegado
                .and().exceptionHandling().accessDeniedPage("/denegado");
        return http.build();
    }

}
