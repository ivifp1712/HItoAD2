package com.example.hitoprueba;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    @Query("SELECT u FROM Usuario u WHERE u.nif = :nif")
    Usuario findByNif(@Param("nif") String nif);
}