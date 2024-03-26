package ru.vorotov.ooap2_lab2;

abstract class AuthenticationDecorator implements Authentication {
    protected Authentication authentication;

    public AuthenticationDecorator(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public boolean authenticate(User user, String enteredLogin, String enteredPassword) {
        return authentication.authenticate(user, enteredLogin, enteredPassword);
    }

    public abstract boolean authenticate(User user, String enteredLogin, String enteredPassword, int OTP);
}
