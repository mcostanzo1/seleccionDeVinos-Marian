package com.dp3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.dp3.config.MongoDBConfig;

@Configuration
@EnableWebSecurity
@Import(value = MongoDBConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/start/**").authenticated()
			.antMatchers("/admin/**").hasRole("ADMIN").and()
		.formLogin()
			.loginPage("/login").failureUrl("/login?error").
			loginProcessingUrl("/loginFormAction").
			usernameParameter("username").
			passwordParameter("password").
			defaultSuccessUrl("/start", true).
			permitAll().
		and()
			.logout().permitAll();
	}
}