package br.com.vemser.pessoaapi.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        boolean valido = true;
        if (token == null) {
            valido = false;
        }

        if (valido) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken("fake", null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(null);
        } else {}

        filterChain.doFilter(request, response);
    }
}
