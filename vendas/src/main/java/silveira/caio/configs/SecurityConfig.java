package silveira.caio.configs;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@Profile("!development")
public class SecurityConfig {

	private static final String API_URL_PATTERN = "/sell-system/api/**";

	@Bean
	SecurityFilterChain seurityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector)
			throws Exception {

		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

//		http.csrf(csrfConfigurer -> csrfConfigurer.ignoringRequestMatchers(mvcMatcherBuilder.pattern(API_URL_PATTERN),
//				PathRequest.toH2Console()));

//		http.csrf(csrfConfigurer -> csrfConfigurer.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));

//		http.headers(
//				headersConfigurer -> headersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

		http.authorizeHttpRequests(auth -> auth.requestMatchers(mvcMatcherBuilder.pattern(API_URL_PATTERN))
				.authenticated().requestMatchers(PathRequest.toH2Console()).authenticated()
//		.oauth2Login(withDefaults()).formLogin(withDefaults())
		);

//		http.oauth2ResourceServer(auth -> auth.jwt(Customizer.withDefaults()));

//		http.formLogin(withDefaults());
//		http.httpBasic(withDefaults());

		return http.build();
	}
}
