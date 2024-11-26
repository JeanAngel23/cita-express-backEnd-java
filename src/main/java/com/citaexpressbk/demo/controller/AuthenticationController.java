package com.citaexpressbk.demo.controller;

import com.citaexpressbk.demo.domain.dto.DataAutenticationUser;
import com.citaexpressbk.demo.domain.entity.Usuario;
import com.citaexpressbk.demo.infra.security.DatosJWT;
import com.citaexpressbk.demo.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid DataAutenticationUser dataAutenticationUser){
        try {
            System.out.println("Iniciando autenticación para el usuario: " + dataAutenticationUser.username());

            // Crear el token de autenticación
            Authentication authToken = new UsernamePasswordAuthenticationToken(
                    dataAutenticationUser.username(),
                    dataAutenticationUser.password()
            );

            // Autenticar el usuario
            var usuarioAuth = authenticationManager.authenticate(authToken);
            System.out.println("Autenticación exitosa para el usuario: " + dataAutenticationUser.username());

            // Obtener los detalles del usuario autenticado
            UserDetails userDetails = (UserDetails) usuarioAuth.getPrincipal();

            // Generar el token JWT
            var JWTtoken = tokenService.generarToken(userDetails);
            System.out.println("Token JWT generado: " + JWTtoken);

            // Devolver el token en la respuesta
            return ResponseEntity.ok(new DatosJWT(JWTtoken));
        } catch (Exception e) {
            // Manejar errores de autenticación
            System.err.println("Error de autenticación: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}

