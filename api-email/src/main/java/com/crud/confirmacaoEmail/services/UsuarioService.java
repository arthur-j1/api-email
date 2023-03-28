package com.crud.confirmacaoEmail.services;

import com.crud.confirmacaoEmail.entitys.Usuario;
import com.crud.confirmacaoEmail.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> save(Usuario usuario){
        usuarioRepository.save(usuario);
        return usuarioRepository.findById(usuario.getUsuario_id());

    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> findAll(){
       return usuarioRepository.findAll();
    }

    public void delete(Usuario usuario){
//        if(this.findById(id).isEmpty()){
//
//        }
        usuarioRepository.delete(usuario);
    }

    public Usuario update(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioAntigo = usuarioRepository.findById(id);
        if (usuarioAntigo.isPresent()) {
            usuarioAntigo.get().setEmail(usuarioAtualizado.getEmail());
            usuarioAntigo.get().setNome(usuarioAtualizado.getNome());
            usuarioAntigo.get().setSenha(usuarioAtualizado.getSenha());
            return usuarioRepository.save(usuarioAntigo.get());

        }
    return null;
    }

    public boolean isCadastrado(String email){
        Usuario usuario= usuarioRepository.findByEmail(email);
        if (usuario == null){
            return false;
        }else{
            return true;
        }

    }

    public Usuario findByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public boolean login(String email, String senha){
        Usuario usuario= usuarioRepository.findByEmail(email);
        if (usuario.getEmail() == email && usuario.getSenha() == senha){
            return true;
        }
        else{
            return false;
        }
    }

}