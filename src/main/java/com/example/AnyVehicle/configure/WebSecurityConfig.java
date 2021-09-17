package com.example.AnyVehicle.configure;

import com.example.AnyVehicle.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
//        String encodedPassword = passwordEncoder().encode("12");
//        authenticationManagerBuilder.inMemoryAuthentication().withUser("otator").password(encodedPassword)
//                .authorities("ADMIN");
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        String encodedPassword = passwordEncoder().encode("11");
        auth.inMemoryAuthentication().withUser("admin").password(encodedPassword)
                .authorities("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()

                .authorizeRequests()
                .antMatchers( "/login", "/signup","/","/assets/**","/fragments/**").permitAll()
                .antMatchers("/requests").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/error403").and()
                .sessionManagement()
                .and().formLogin().loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true).failureUrl("/login")
                .and().logout()
                .logoutUrl("/perform_logout")
                .logoutSuccessUrl("/").deleteCookies("JSESSIONID");

    }

}
