package com.crud.confirmacaoEmail.excecoes;

import com.crud.confirmacaoEmail.entitys.Usuario;
import org.springframework.data.crossstore.ChangeSetPersister;

public class UsuarioNaoEncontradoException extends RuntimeException {
    Usuario usuario;
}
