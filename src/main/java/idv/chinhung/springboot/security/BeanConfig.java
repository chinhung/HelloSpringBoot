package idv.chinhung.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class BeanConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return new SecurityUserService();
	}
	
	@Bean
	public TokenFilter tokenFilter() {
		return new TokenFilter();
	}
}
