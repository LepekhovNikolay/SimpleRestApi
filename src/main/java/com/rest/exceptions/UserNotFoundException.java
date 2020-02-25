package com.rest.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super(String.format("Пользователь с id = %d не найден", id));
    }
}
