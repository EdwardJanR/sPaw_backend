package com.generation.sPaw_backend.controller;


import com.generation.sPaw_backend.JwtUtil;
import com.generation.sPaw_backend.dto.UsuarioDto;
import com.generation.sPaw_backend.model.Usuario;
import com.generation.sPaw_backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registro")
    public ResponseEntity<String> register(@RequestBody Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok("Usuario registrado con éxito");
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody User user) {
//        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
//        if (userDetails != null && passwordEncoder.matches(user.getPassword(), userDetails.getPassword())) {
//            String token = jwtUtil.generateToken(userDetails.getUsername());
//            return ResponseEntity.ok(token);
//        }
//        return ResponseEntity.status(401).body("Credenciales inválidas");
//    }

    @PostMapping("/loginConDTO")
    public ResponseEntity<String> loginConDTO(@RequestBody UsuarioDto usuarioDto) {
        UserDetails userDetails = usuarioService.loadUserByEmail(usuarioDto.getEmail());
        if (userDetails != null && passwordEncoder.matches(usuarioDto.getPasswordUsuario(), userDetails.getPassword())) {
            String token = jwtUtil.generateToken(userDetails.getUsername());
            System.out.println(userDetails.getPassword());
            System.out.println(userDetails.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }

    @GetMapping("/resource")
    @PreAuthorize("hasRole('Cliente')")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("Este es un recurso protegido!");
    }
}
