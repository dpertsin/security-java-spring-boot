package com.dpertsin.security.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController is a REST controller that handles requests to the /api/v1/demo endpoint.
 */
@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    /**
     * Handles GET requests to the /api/v1/demo endpoint.
     *
     * @return a ResponseEntity containing a greeting message
     */
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello World, from a secured endpoint!");
    }
}
