package br.com.filme.quiz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.filme.quiz.model.Usuario;

@RestController
public class UserController {

	@PostMapping("/login")
	public ResponseEntity<String> login(){
		toString();
//		try {
//            var authenticate = authenticationManager
//                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getPassword()));
//
//            var principal = (Usuario) authenticate.getPrincipal();
//
//            var token = jwtTokenUtil.generateAccessToken(principal);
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.AUTHORIZATION, token)
//                    .body(principal.getUsername() + " token - "+ token);
//        } catch (BadCredentialsException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
//	@PostMapping("/logout")
//	public ResponseEntity<String> logout(){
//		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//	}
//	
}
