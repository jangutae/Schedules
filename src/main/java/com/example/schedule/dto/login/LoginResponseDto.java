package com.example.schedule.dto.login;

import com.example.schedule.entity.User;
import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.tomcat.util.codec.binary.StringUtils;

@Getter
public class LoginResponseDto {

    private final String password;

    private final String email;

    public LoginResponseDto(User user) {
        this.password = user.getPassword();
        this.email = user.getEmail();

    }
}
