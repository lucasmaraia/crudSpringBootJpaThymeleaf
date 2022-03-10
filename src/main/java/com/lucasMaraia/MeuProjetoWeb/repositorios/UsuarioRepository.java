package com.lucasMaraia.MeuProjetoWeb.repositorios;

import com.lucasMaraia.MeuProjetoWeb.modelos.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    public Long countByusuarioID( Long usuarioID);
}
