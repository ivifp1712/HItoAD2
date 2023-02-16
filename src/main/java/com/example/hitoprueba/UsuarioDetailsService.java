package com.example.hitoprueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UsuarioDetalles loadUserByUsername(String nif)
            throws UsernameNotFoundException {
        Usuario user = userRepository.findByNif(nif);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new UsuarioDetalles(user);
    }
}
