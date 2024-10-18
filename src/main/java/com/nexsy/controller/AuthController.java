package com.nexsy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexsy.config.JwtUtil;
import com.nexsy.model.AuthRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        if ("usuarioEjemplo".equals(authRequest.getUsername()) && "contraseñaEjemplo".equals(authRequest.getPassword())) {
            return jwtUtil.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("Credenciales invalidas");
        }
    }
}

