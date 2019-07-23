package org.sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{
	@Autowired	
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception{
			auth.inMemoryAuthentication().withUser("admin").password("123").roles("admin");
			auth.inMemoryAuthentication().withUser("khalid").password("khalid").roles("etudiant");

		}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login");
	}
}
