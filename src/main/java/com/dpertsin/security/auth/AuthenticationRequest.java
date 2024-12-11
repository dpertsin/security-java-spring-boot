package com.dpertsin.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents an authentication request.
 * It is used to encapsulate the data required for user authentication.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    /**
     * The email of the user attempting to authenticate.
     */
    private String email;

    /**
     * The password of the user attempting to authenticate.
     */
    private String password;
}
