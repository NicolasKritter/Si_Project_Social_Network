package hello.config;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebSecurity
@EnableWebMvc
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Resource(name = "userDetailService")
	private UserDetailsService userDetailsService;
		
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
        http
        	
            .authorizeRequests()
                .antMatchers("/","/resources/css/**","/API/LDAP-synchro/**").permitAll()
                .anyRequest().authenticated()  
                .and()
            .formLogin()
                .loginPage("/utilisateur/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/utilisateur/fil-actu")
                .failureUrl("/utilisateur/error")
                .permitAll()
                .and()
            .logout()
            	.logoutUrl("/utilisateur/logout")
            	.logoutSuccessUrl("/utilisateur/logged_out")
                .permitAll();
        http.csrf().disable();
    }
	
		 
	
	@Bean
	public LdapShaPasswordEncoder passwordEncoder() {
		
		
	    return new LdapShaPasswordEncoder();
	}

	@Bean
	public PasswordEncoder KeydEncoder() {
	    return new BCryptPasswordEncoder();
	}

	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
   //https://stackoverflow.com/questions/31826233/custom-authentication-manager-with-spring-security-and-java-configuration
              
    }
    

    

    

    
    
    
    
}