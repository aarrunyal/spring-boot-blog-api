package com.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.blog.security.CustomUserDetailService;


//
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private static final String[] SECURED_URLS= {"/posts/**", "/comments/**", "/category/**"};
	private static final String[] UN_SECURED_URLS= {"/api/users/create"};
	
	@Autowired
	private JwtAuthFilter jwtAuthFilter;
    
	@Bean
//	authentication
	public UserDetailsService userDetailService(PasswordEncoder encoder) throws Exception{
//		UserDetails admin = User.builder().username("aarrunyal").password(encoder.encode("aarrunyal")).roles("ADMIN")
//				.build();
//		UserDetails user = User.builder().username("aarrunyall").password(encoder.encode("test")).roles("USER").build();
//		return new InMemoryUserDetailsManager(admin, user);

		 return new CustomUserDetailService();
	}


	@Bean
//	Authorization
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.authorizeHttpRequests().requestMatchers(UN_SECURED_URLS).permitAll()
				.and().
				authorizeHttpRequests().requestMatchers(SECURED_URLS).hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().
                authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Bean
    public AuthenticationProvider authenticationProvider() throws Exception {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService(null));
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return  configuration.getAuthenticationManager();
    }

}
