package com.iamdevmarcos.jobs_management.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário já existe!");
    }
}
