package ru.vorotov.ooap2_lab2;

public class BaseAuthentication implements Authentication {
    @Override
    public boolean authenticate(User user, String enteredLogin, String enteredPassword) {
        if (user.getUsername().equals(enteredLogin) && user.getPassword().equals(enteredPassword)) {
            return true;
        }
        return false;
    }
}
