package com.arianemoura.primeiro_projeto_springboot.exceptions;

public class UserFoundException extends RuntimeException {

    public UserFoundException(String usuárioJáExiste){
        super("Usuário já existe");
    }

}
