package ru.dediev.springCloudSecurity.rest;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String email;
    private String password;
}
