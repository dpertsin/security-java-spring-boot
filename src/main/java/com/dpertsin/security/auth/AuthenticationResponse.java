package com.dpertsin.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents an authentication response.
 * It is used to encapsulate the data returned after a successful authentication.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    /**
     * The JWT token generated after successful authentication.
     */
    private String token;
}
