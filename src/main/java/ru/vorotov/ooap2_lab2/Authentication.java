package ru.vorotov.ooap2_lab2;

public interface Authentication {
    boolean authenticate(User user, String enteredLogin, String enteredPassword);
}
