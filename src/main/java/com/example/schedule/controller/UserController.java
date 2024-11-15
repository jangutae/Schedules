package com.example.schedule.controller;

import com.example.schedule.dto.login.LoginRequestDto;
import com.example.schedule.dto.login.LoginResponseDto;
import com.example.schedule.dto.signup.SignUpRequestDto;
import com.example.schedule.dto.signup.SignUpResponseDto;
import com.example.schedule.dto.user.UserResponseDto;
import com.example.schedule.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    // 유저 생성
    @PostMapping
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                userService.signUp(requestDto.getUsername(), requestDto.getPassword(), requestDto.getEmail());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }
    // 특정 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {

        UserResponseDto userResponseDto = userService.findUserById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    // 로그인 요청 Void로 응답 코드만 return
    @PostMapping("/signup")
    public ResponseEntity<Void> login(
            @RequestBody LoginRequestDto requestDto,
            HttpServletResponse response
    ) {
        LoginResponseDto loginResponseDto = userService.login(requestDto.getEmail(), requestDto.getPassword());

        Cookie cookie = new Cookie("password",(loginResponseDto.getPassword()));

        // Cookie에 비밀번호를 저장
        response.addCookie(cookie);


        return new ResponseEntity<>(HttpStatus.OK);
    }

}
