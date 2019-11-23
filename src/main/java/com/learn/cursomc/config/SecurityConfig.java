package com.learn.cursomc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private Environment env;
	
	public static final String[] PUBLIC_MATCHES = {
		"/h2-console/**"
	};
	
	public static final String[] PUBLIC_MATCHES_GET = {
		"/produtos/**",
		"/categorias/**"
	};
	
	protected void configure(HttpSecurity http) throws Exception {
		// configuracao para peculiaridade do DB em memoria H2
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		// ativa o metodo abaixo corsConfigurationSource()
		http.cors().
		// desabilita protecao CSRF em sistemas stateless 
		and().csrf().disable();
		
		http.
		// autoriza todos os caminhos do vetor PUBLIC_MATCHES
		authorizeRequests().
		antMatchers(HttpMethod.GET, PUBLIC_MATCHES_GET).permitAll().
		antMatchers(PUBLIC_MATCHES).permitAll().
		
		// exige autenticacao para caminhos nao existentes no vetor PUBLIC_MATCHES
		anyRequest().authenticated();
		super.configure(http);
		
		// assegura que esse back-ende nao crie sessao de usuario
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	protected CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}