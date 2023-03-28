package com.crud.confirmacaoEmail.controller;

import com.crud.confirmacaoEmail.entitys.Usuario;
import com.crud.confirmacaoEmail.excecoes.UsuarioNaoEncontradoException;
import com.crud.confirmacaoEmail.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos(){
        return new ResponseEntity<>(usuarioService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/criar-usuario")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> procurarPeloId(@PathVariable("id") Long id){
        Usuario usuarioBanco = usuarioService.findById(id);
        if(usuarioBanco == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarioBanco, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable("id") Long id){
        Usuario usuario = usuarioService.findById(id);
        if (usuario!=null){
            usuarioService.delete(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    


}
