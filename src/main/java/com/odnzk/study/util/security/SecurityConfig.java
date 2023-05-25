package com.odnzk.study.util.security;

import com.odnzk.study.config.TodoListerEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService service;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/static/**", "/css/**", "/img/**", "/js/**");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf()
                .ignoringRequestMatchers(
                        TodoListerEndpoint.LOGIN,
                        TodoListerEndpoint.SIGNUP,
                        TodoListerEndpoint.PROJECTS,
                        TodoListerEndpoint.ARCHIVE_PROJECT,
                        TodoListerEndpoint.STATS,
                        allPaths(TodoListerEndpoint.TASKS),
                        allPaths(TodoListerEndpoint.PROFILE),
                        allPaths(TodoListerEndpoint.RESTORE_PASSWORD))
                // todo remove
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeHttpRequests()
                .requestMatchers(
                        TodoListerEndpoint.LOGIN,
                        TodoListerEndpoint.SIGNUP,
                        TodoListerEndpoint.ERROR,
                        TodoListerEndpoint.DEFAULT
                ).permitAll()
                .requestMatchers(
                        TodoListerEndpoint.LOGOUT,
                        allPaths(TodoListerEndpoint.PROJECTS),
                        allPaths(TodoListerEndpoint.PROFILE),
                        allPaths(TodoListerEndpoint.ACHIEVEMENTS),
                        allPaths(TodoListerEndpoint.TASKS),
                        allPaths(TodoListerEndpoint.STATS),
                        allPaths(TodoListerEndpoint.RESTORE_PASSWORD),
                        allPaths(TodoListerEndpoint.ARCHIVE_PROJECT)
                ).authenticated()
                .requestMatchers(TodoListerEndpoint.ADMIN).hasAuthority("ADMIN")
                .and()
                .formLogin()
                .loginPage(TodoListerEndpoint.LOGIN)
                .successForwardUrl(TodoListerEndpoint.PROJECTS)
                .defaultSuccessUrl(TodoListerEndpoint.PROJECTS)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(TodoListerEndpoint.LOGOUT, "GET"))
                .logoutSuccessUrl(TodoListerEndpoint.LOGIN)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .build();
    }

    @Autowired
    public void bindService(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(service).passwordEncoder(passwordEncoder);
    }

    private String allPaths(String path) {
        return path + "/**";
    }
}
