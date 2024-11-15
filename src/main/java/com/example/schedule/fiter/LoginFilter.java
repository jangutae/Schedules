package com.example.schedule.fiter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

// 요청 URL이 /users/signup 인 경우 제외하고 doFilter 매서드 실행
@Slf4j
public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/users/*","/users","/schedules","/schedules/*"};

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {

        // 다양한 기능을 사용하기 위해 다운 캐스팅
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        log.info("로그인 필터 로직 실행");

        if (!isWhiteList(requestURI)) {

            HttpSession session = httpRequest.getSession(false );

            if (session == null || session.getAttribute("user") == null) {
                throw new RuntimeException("로그인 해주세요");
            }

            // 로그인 성공 로직
            log.info("로그인 성공 로직");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isWhiteList(String requestURI) {

        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
