package com.generation.sPaw_backend.service;

import java.util.List;
import java.util.Optional;
import com.generation.sPaw_backend.model.Usuario;

public interface IUsuarioService {
    List<Usuario> obtenerTodos();
    Optional<Usuario> obtenerPorId(Long id);
    Usuario guardarUsuario(Usuario usuario);

    //Metodo para eliminar usuario
    void eliminarUsuario(Long id);

    //Metodo para editar usuario
    void editarUsuario(Long id, Usuario usuarioActualizado);
}
