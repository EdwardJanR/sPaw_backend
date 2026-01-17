package com.generation.sPaw_backend.controller;

import com.generation.sPaw_backend.model.Mascota;
import com.generation.sPaw_backend.model.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.generation.sPaw_backend.model.Usuario;
import com.generation.sPaw_backend.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private  final UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listaUsuarios(){
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable Long id){
        return usuarioService.obtenerPorId(id)
                .orElse(new Usuario());
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok("Usuario publicado con éxito");
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            usuarioService.actualizarUsuario(id, usuario);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id){
        usuarioService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado con éxito");
    }
	
	@PostMapping("/{id}/mascotas")
	public Usuario agregarMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
		return usuarioService.agregarMascota(id, mascota);
	}

}