package de.labvision.auth;

public class AuthService {

    public boolean login(String username, String password) {
        return username != null && !username.isEmpty()
                && password != null && !password.isEmpty();
    }
}
