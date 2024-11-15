package com.example.schedule.service;

import com.example.schedule.dto.login.LoginResponseDto;
import com.example.schedule.dto.signup.SignUpResponseDto;
import com.example.schedule.dto.user.UserResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //UserRepository 로 유저 생성 요청
    public SignUpResponseDto signUp(String username, String password, String email) {

        User user = new User(username, password, email);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    //UserRepository 로 유저 조회 요청
    public UserResponseDto findUserById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dose not exist id = " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUsername(), findUser.getEmail());
    }

    //UserRepository 로 유저 삭제 요청
    public void delete(Long id) {

        userRepository.deleteById(id);
    }

    // UserRepository 로 email 과 password 값에 따라 일치하는 User 요청 및 예외처리
    public LoginResponseDto login(String email, String password) {

        User user = userRepository.logIn(email, password);

        // email 과 password null 값인 경우
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid email or password");
        }

        if (!user.getEmail().equals(email) || !user.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }

        return new LoginResponseDto(user);
    }
}


