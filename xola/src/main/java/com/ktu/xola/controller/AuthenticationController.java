package com.ktu.xola.controller;

import com.ktu.xola.repository.AuthenticationRequest;
import com.ktu.xola.repository.UserRepository;
import com.ktu.xola.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userDetailsService;
    private final JwtUtils jwtUtils;
@PostMapping
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        final UserDetails userDetails = (UserDetails) userDetailsService.findByEmail(request.getEmail());
        if (userDetails != null){
            return ResponseEntity.ok(jwtUtils.generateToken(userDetails)) ;
        }
        return ResponseEntity.status(400).body("error occured");
    }
}
