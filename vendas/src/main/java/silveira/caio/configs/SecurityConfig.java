package silveira.caio.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Value("${security.enable:true}")
	private boolean securityEnable;

	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		if (securityEnable)
			return (web) -> web.getOrBuild();
		return (web) -> web.ignoring().anyRequest();
	}

	@Bean
	UserDetailsService userDetailsService() {
		UserDetails user = User.builder().username("caio").password("123").roles("roles").build();
		UserDetails admin = User.builder().username("admin").password("password").roles("ADMIN", "USER").build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	
}
