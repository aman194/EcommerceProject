package shoppingf1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/onlineshopping1");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.jdbcAuthentication()
			.usersByUsernameQuery("select email,password,enabled from customer where email = ?")
			.authoritiesByUsernameQuery("select email,role from customer where email=?")
			.dataSource(getDataSource())
			.passwordEncoder(NoOpPasswordEncoder.getInstance());
			
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/home").permitAll()
			.antMatchers("resources/**").permitAll()
			.anyRequest().authenticated()
					.and()
			.formLogin().loginPage("/login").permitAll()
			.usernameParameter("email").passwordParameter("pwd")
			.loginProcessingUrl("/signin")
			.defaultSuccessUrl("/home")
							.failureUrl("/login?error")
				.and()
			.logout().logoutSuccessUrl("/login?logout");
	}
}
