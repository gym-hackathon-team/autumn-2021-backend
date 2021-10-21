package com.gymteam.backend.bff.filter;

import com.gymteam.backend.bff.client.AuthClient;
import com.gymteam.backend.bff.dto.auth.AuthorizedDto;
import com.gymteam.backend.bff.security.Authorized;
import com.gymteam.backend.bff.config.WebSecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class JwtFilter extends GenericFilterBean {

    public static final String AUTHORIZATION = "Authorization";

    private final AuthClient authClient;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI().substring(request.getContextPath().length());

        if (Arrays.asList(WebSecurityConfig.AUTH_WHITELIST).contains(path)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Optional<String> jwt = getTokenFromRequest((HttpServletRequest) servletRequest);

        jwt.ifPresent(token -> {
            Optional<AuthorizedDto> authorization = authClient.authorize(token);
            authorization.ifPresent(scope -> {
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(new Authorized(scope.getScope()), null, null);
                SecurityContextHolder.getContext().setAuthentication(auth);
            });
        });

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Optional<String> getTokenFromRequest(HttpServletRequest request) {
        Optional<String> bearer = Optional.ofNullable(request.getHeader(AUTHORIZATION));
        return bearer.map(s -> s.substring(7));
    }
}