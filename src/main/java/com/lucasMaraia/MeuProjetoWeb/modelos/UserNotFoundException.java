package com.lucasMaraia.MeuProjetoWeb.modelos;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message) {
        super(message);
    }
}
