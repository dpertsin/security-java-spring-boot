package com.dpertsin.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
    * This class is a controller for the authentication.
    * It is used to handle the requests related to the authentication.
    * It has two endpoints to register and authenticate the user.
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    /**
     * Registers a new user.
     *
     * @param registerRequest the registration request containing user details
     * @return a ResponseEntity containing the authentication response with a JWT token
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ){
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    /**
     * Authenticates a user.
     *
     * @param authenticationRequest the authentication request containing user credentials
     * @return a ResponseEntity containing the authentication response with a JWT token
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest
    ){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
