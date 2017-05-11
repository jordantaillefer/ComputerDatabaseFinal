package com.main.excilys.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

  @Autowired
  public void configAuthentication(AuthenticationManagerBuilder auth, PasswordEncoder passEncoder)
      throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username,password, enabled from users where username=?")
        .authoritiesByUsernameQuery("select username, role from user_roles where username=?")
        .passwordEncoder(passEncoder);
  }
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.csrf().ignoringAntMatchers("/computers**", "/computers/**").and().authorizeRequests()
        .antMatchers("/", "/dashboard").permitAll()
        .antMatchers("/addComputer", "/editComputer", "/deleteComputer").hasAnyRole("ADMIN", "USER")
        .and().formLogin().loginPage("/login").defaultSuccessUrl("/dashboard").and().logout()
        .permitAll();
  }

}