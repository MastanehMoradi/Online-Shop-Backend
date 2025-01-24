package com.example.shop_store_back.api;

import com.example.shop_store_back.service.GoogleAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final GoogleAuthService googleAuthService;

    public AuthController(GoogleAuthService googleAuthService) {
        this.googleAuthService = googleAuthService;
    }

//    @CrossOrigin(origins = "http://localhost:5173") // Allow frontend origin
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String idToken) {
        try {
            var payload = googleAuthService.verifyToken(idToken);

            // Example: Get user details
            String userId = payload.getSubject();
            String email = payload.getEmail();
            String name = (String) payload.get("name");

            // Handle session or JWT creation for your application
            return ResponseEntity.ok("User authenticated: " + email);
//            return null;

        } catch (Exception e) {
            return ResponseEntity.status(401).body("Authentication failed");
        }
    }
}

