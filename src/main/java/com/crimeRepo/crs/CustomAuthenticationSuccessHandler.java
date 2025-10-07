package com.crimeRepo.crs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        if (role.equals("ROLE_USER")) {
            response.sendRedirect("/user/dashboard");
        } else if (role.equals("ROLE_POLICE")) {
            response.sendRedirect("/police/dashboard");
        } else if (role.equals("ROLE_ADMIN")) {
            response.sendRedirect("/admin/dashboard");
        } else {
            response.sendRedirect("/login?error"); // fallback
        }
    }
}


