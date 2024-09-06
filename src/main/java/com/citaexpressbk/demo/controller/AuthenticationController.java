package com.citaexpressbk.demo.controller;

import com.citaexpressbk.demo.domain.dto.DataAutenticationUser;
import com.citaexpressbk.demo.domain.entity.Usuario;
import com.citaexpressbk.demo.infra.security.DatosJWT;
import com.citaexpressbk.demo.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DataAutenticationUser dataAutenticationUser){
        System.out.println("dataAutenticationUser: " + dataAutenticationUser.username());
        Authentication authToken = new UsernamePasswordAuthenticationToken(dataAutenticationUser.username(),
                dataAutenticationUser.password());
        System.out.println("isAuthenticated: " + authToken.isAuthenticated());
        var usuarioAuth = authenticationManager.authenticate(authToken);
        System.out.println("usuarioAuth: " + usuarioAuth);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAuth.getPrincipal());
        System.out.println("JWTtoken: " + JWTtoken);
        return ResponseEntity.ok(new DatosJWT(JWTtoken));
    }

}
