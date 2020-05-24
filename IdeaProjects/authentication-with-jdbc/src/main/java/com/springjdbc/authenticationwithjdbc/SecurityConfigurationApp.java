package com.springjdbc.authenticationwithjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfigurationApp extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Fo InMemory database:
        //        auth.jdbcAuthentication().dataSource(dataSource)
        //        .withDefaultSchema().withUser(User.withUsername("abc").password("abc123").roles("Admin"))
        //                            .withUser(User.withUsername("efg").password("efg123").roles("User"));

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("Select username,password,enabled from users where username =?")
                .authoritiesByUsernameQuery("Select username,authority from authorities where username =?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("Admin")
                .antMatchers("/user").hasAnyRole("User","Admin")
                .antMatchers("/").permitAll().and().formLogin();
    }

    @Bean
    public PasswordEncoder doPasswordEncode(){
        return NoOpPasswordEncoder.getInstance();
    }
}
