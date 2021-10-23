package com.gymteam.backend.bff.config;

import com.gymteam.backend.bff.filter.JwtFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    private final JwtFilter jwtFilter;

    public static final String[] AUTH_WHITELIST = {
            // GraphQL playground
            "/graphiql",
            "/vendor/**",

            // Service Discovery
            "/my-health-check",

            // Auth
            "/auth/**"
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.csrf().disable();
        http.cors().disable();

        http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll();
        //http.authorizeRequests().antMatchers("/**").authenticated();
        http.authorizeRequests().antMatchers("/**").permitAll();
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}