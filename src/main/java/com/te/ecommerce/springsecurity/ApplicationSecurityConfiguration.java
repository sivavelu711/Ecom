package com.te.ecommerce.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http
//		.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/","index","/css/*","/js/*").permitAll()
//		.antMatchers("/api/**").hasRole(ApplicationUserRole.CUSTOMER.name())
//		.anyRequest()
//		.authenticated()
//		.and()
//		.httpBasic();
//	}
    @Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails annaSmithUser=User.builder()
				.username("annasmith")
				.password(passwordEncoder.encode("password"))
				.roles(ApplicationUserRole.CUSTOMER.name())
				.authorities(ApplicationUserRole.CUSTOMER.getGrantedAuthorities())
				.build();
		
		
		UserDetails tomUser=User.builder()
				.username("tom")
				.password(passwordEncoder.encode("password123"))
				.roles(ApplicationUserRole.MANAGER.name())
				.authorities(ApplicationUserRole.MANAGER.getGrantedAuthorities())
				.build();
		return new InMemoryUserDetailsManager(annaSmithUser,tomUser);
	}
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/register/**").permitAll()
		.antMatchers("management/api/v1/customers").permitAll();
//		.antMatchers("/customer/**").permitAll()
//		.antMatchers("/authority/**").permitAll();
//		
//		http.exceptionHandling().authenticationEntryPoint(invalidUserAuthEntryPoint).and().sessionManagement();
//		
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
//		http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

	}
	

}
