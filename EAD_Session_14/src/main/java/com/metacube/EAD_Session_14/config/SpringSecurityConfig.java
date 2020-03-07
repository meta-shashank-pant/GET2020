package com.metacube.EAD_Session_14.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    DataSource dataSource;
	
	@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
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
     
    @SuppressWarnings("deprecation")
    @Bean
       public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
       }

}