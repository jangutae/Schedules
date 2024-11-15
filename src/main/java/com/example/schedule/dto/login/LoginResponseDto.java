package com.example.schedule.dto.login;

import com.example.schedule.entity.User;
import lombok.Getter;

@Getter
public class LoginResponseDto {

    private final String password;

    private final String email;

    public LoginResponseDto(User user) {
        this.password = user.getPassword();
        this.email = user.getEmail();

    }
}
