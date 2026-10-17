package br.com.ctw.helpdesk_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.AntPathMatcher;

@Configuration
@Profile("dev")
public class DevSecurityConfig {

    @Bean
    public SecurityFilterChain devFilterChain(HttpSecurity http) throws Exception {

        return http
                .securityMatcher("/h2-console/**")
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .csrf( crsf -> crsf.ignoringRequestMatchers( "/h2-console/**")
        )
                .headers( headers -> headers.frameOptions(frame -> frame.sameOrigin()
                        )
                )
                .build();
    }
}
