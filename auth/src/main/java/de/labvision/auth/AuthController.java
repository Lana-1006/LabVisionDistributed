package de.labvision.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService = new AuthService();

    @GetMapping("/login")
public String login(@RequestParam("username") String username,
                    @RequestParam("password") String password) {

    boolean loginSuccessful = authService.login(username, password);

    if (loginSuccessful) {
        return "Auth-Service result: Login successful for user lana";
    }

    return "Auth-Service result: Login failed";
}
}