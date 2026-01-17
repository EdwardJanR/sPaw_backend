package com.generation.sPaw_backend.service;

import com.generation.sPaw_backend.model.Mascota;
import com.generation.sPaw_backend.model.Rol;
import com.generation.sPaw_backend.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.generation.sPaw_backend.model.Usuario;
import com.generation.sPaw_backend.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    private final IUsuarioRepository UsuarioRepository;
    private final IMascotaRepository mascotaRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository, IMascotaRepository mascotaRepository) {
        UsuarioRepository = usuarioRepository;
        this.mascotaRepository = mascotaRepository;
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
            usuarioExistente.setPasswordUsuario(usuarioActualizado.getPasswordUsuario());
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
		
		mascota.setUsuario(usuario);
		usuario.getMascotas().add(mascota);
		
		return UsuarioRepository.save(usuario);
	}

    @Override
    public void actualizarMascota(Long id, Mascota mascotaActualizada) {

        Mascota mascotaBuscada = mascotaRepository.findById(id).orElseThrow(() -> new RuntimeException("Mascota no enctrada con el id: " + id ));
        mascotaBuscada.setNombreMascota(mascotaActualizada.getNombreMascota());
        mascotaBuscada.setUsuario(mascotaActualizada.getUsuario());
        mascotaRepository.save(mascotaBuscada);
    }

    @Override
    public List<Usuario> obtenerPorRol(String rol) {
        return UsuarioRepository.findByRol(Rol.valueOf(rol));
    }
}