package com.crud.confirmacaoEmail.repositorys;

import com.crud.confirmacaoEmail.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByEmail(String email);
}
