package demospringsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter  {

	
	private PasswordEncoder encoder;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("Mahesh")
		.password("Mahesh")
		.roles("admin");
	}

	 

	public PasswordEncoder getEncoder() {
		return encoder;
	}

	@Autowired
	@Qualifier("nopps")
	public void setEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	} 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
       super.configure(http);
	}
}
