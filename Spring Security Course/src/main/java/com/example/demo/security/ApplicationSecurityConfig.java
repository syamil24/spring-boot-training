package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.example.demo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

        private final PasswordEncoder passwordEncoder;

        @Autowired
        public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
                this.passwordEncoder = passwordEncoder;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http
                                .csrf().disable() // TODO
                                .authorizeRequests()
                                .antMatchers("/", "index", "/css/*", "/js/*")
                                .permitAll()
                                .antMatchers("/api/**").hasRole(STUDENT.name()) // role-based
                                // .antMatchers(HttpMethod.DELETE, "/management/api/**")
                                // .hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                                // .antMatchers(HttpMethod.POST, "/management/api/**")
                                // .hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                                // .antMatchers(HttpMethod.PUT, "/management/api/**")
                                // .hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                                // .antMatchers(HttpMethod.GET,
                                // "/management/api/**")
                                // .hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                                .anyRequest()
                                .authenticated()
                                .and()
                                .httpBasic();
        }

        @Override
        @Bean
        protected UserDetailsService userDetailsService() {
                UserDetails madlimUser = User.builder()
                                .username("madlim")
                                .password(passwordEncoder.encode("password"))
                                // .roles(STUDENT.name()) // ROLE_STUDENT internally
                                .authorities(STUDENT.getGrantedAuthorities())
                                .build();

                UserDetails madlim2User = User.builder()
                                .username("madlim2")
                                .password(passwordEncoder.encode("password"))
                                // .roles(ADMIN.name())
                                .authorities(ADMIN.getGrantedAuthorities())
                                .build();

                UserDetails tomUser = User.builder()
                                .username("tom")
                                .password(passwordEncoder.encode("password"))
                                // .roles(ADMINTRAINEE.name())
                                .authorities(ADMINTRAINEE.getGrantedAuthorities())
                                .build();

                return new InMemoryUserDetailsManager(
                                madlimUser,
                                madlim2User,
                                tomUser);
        }
}
