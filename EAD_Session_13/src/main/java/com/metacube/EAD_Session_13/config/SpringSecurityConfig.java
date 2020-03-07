package com.metacube.EAD_Session_13.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
          .and()
          .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
          .and()
          .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
    }
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
          .csrf().disable()
          .authorizeRequests()
          .antMatchers("/addStudent").hasRole("ADMIN")
          .antMatchers("/showStudent").hasAnyRole("USER","ADMIN")
          .antMatchers("/anonymous*").anonymous()
          .antMatchers("/login").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/login")
          .loginProcessingUrl("/perform_login")
          .defaultSuccessUrl("/home?logged=1", true)
          .failureUrl("/login?error=1")
          //.failureHandler(authenticationManager())
          .and()
          .logout()
          .and()
          .exceptionHandling().accessDeniedPage("/home?denied=1");
        //  .logoutSuccessHandler(logoutSuccessHandler());
    }
     
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}