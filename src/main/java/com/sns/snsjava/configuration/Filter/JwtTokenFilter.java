package com.sns.snsjava.configuration.Filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//        header
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(header == null || header.startsWith("Bearer ")) {
            log.error("Error occurs while getting header");
            filterChain.doFilter(request, response);
            return;
        }
        try {
            final String token = header.split(" ")[1].trim();

//            TODO : check token is valid
//            TODO : get userName from token
            String userName = "";

//            TODO : verified userName is valid
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                    TODO :
                    null, null, null
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }


    }
}
