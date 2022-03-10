package com.lucasMaraia.MeuProjetoWeb.servicos;

import com.lucasMaraia.MeuProjetoWeb.modelos.UserNotFoundException;
import com.lucasMaraia.MeuProjetoWeb.modelos.Usuario;
import com.lucasMaraia.MeuProjetoWeb.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> listarTodosUsuarios() {
        return (List<Usuario>) repo.findAll();

    }

    public void salvar(Usuario usuario) {
        repo.save(usuario);
    }

    public Usuario get(Long usuarioID) throws UserNotFoundException {
        Optional<Usuario> resultado = repo.findById(usuarioID);
        if (resultado.isPresent()) {
            return resultado.get();
        }
            throw new UserNotFoundException("Não foi possível encontrar nenhum usuario com o ID " + usuarioID);

    }

    public void deletar(Long usuarioID) throws UserNotFoundException {
       Long count =  repo.countByusuarioID(usuarioID);
        if(count == null || count == 0){
            throw new UserNotFoundException("Não foi possível encontrar nenhum usuario com o ID " + usuarioID);
        }
         repo.deleteById(usuarioID);
    }

}

