package com.example.bj_isfp_backend.global.config;

import com.example.bj_isfp_backend.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .cors().disable()
                .formLogin().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()

                .antMatchers(HttpMethod.POST, "/user/register").permitAll()
                .antMatchers(HttpMethod.POST, "/user/token").permitAll()
                .antMatchers(HttpMethod.POST, "user/password").permitAll()
                .antMatchers(HttpMethod.POST, "/user/place").permitAll()

                .antMatchers(HttpMethod.GET, "/post").permitAll()
                .antMatchers(HttpMethod.POST, "post/make").permitAll()
                .antMatchers(HttpMethod.DELETE, "/post/{post-id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/post/report/{post-id}").permitAll()
                .antMatchers(HttpMethod.POST, "/post/wish/{post-id}").permitAll()

                .antMatchers(HttpMethod.GET, "/mypage").permitAll()
                .antMatchers(HttpMethod.GET, "/mypage/sold").permitAll()
                .antMatchers(HttpMethod.GET, "/mypage/bought").permitAll()
                .antMatchers(HttpMethod.GET, "/mypage/wished").permitAll()

                .antMatchers(HttpMethod.POST, "/auth").permitAll()

                .antMatchers(HttpMethod.GET, "/profile").permitAll()
                .antMatchers(HttpMethod.GET, "/profile/soled").permitAll()
                .antMatchers(HttpMethod.GET, "/profile/bought").permitAll()
                .antMatchers(HttpMethod.GET, "/profile/wished").permitAll()

                .anyRequest().authenticated()

                .and()
                .apply(new FilterConfig(jwtTokenProvider));
    }
}
