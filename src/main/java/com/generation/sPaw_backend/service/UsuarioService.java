package com.generation.sPaw_backend.service;

import com.generation.sPaw_backend.model.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.generation.sPaw_backend.model.Usuario;
import com.generation.sPaw_backend.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    private final IUsuarioRepository UsuarioRepository;

    @Autowired
    public UsuarioService(IUsuarioRepository UsuarioRepository) {
        this.UsuarioRepository = UsuarioRepository;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return UsuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return UsuarioRepository.findById(id);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return UsuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        UsuarioRepository.deleteById(id);
    }

    @Override
    public void editarUsuario(Long id, Usuario usuarioActualizado) {
        //Saber si existe
        Usuario usuarioExistente = UsuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con el id: " + id));

        //Actualizar los campos de usuario existente
        if (usuarioExistente != null){
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellido(usuarioActualizado.getApellido());
            usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
            usuarioExistente.setEmail(usuarioActualizado.getEmail());
            usuarioExistente.setPassword(usuarioActualizado.getPassword());
            usuarioExistente.setRol(usuarioActualizado.getRol());

            // Guardar el usuario actualizado
            UsuarioRepository.save(usuarioExistente);
        } else {
            throw new RuntimeException("Usuario no encontrado con el id: " + id);
        }
    }
	
	@Override
	public Usuario agregarMascota(Long idUsuario, Mascota mascota) {
		Usuario usuario = UsuarioRepository.findById(idUsuario)
				                  .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		
		mascota.setDueno(usuario);
		usuario.getMascotas().add(mascota);
		
		return UsuarioRepository.save(usuario);
	}
}