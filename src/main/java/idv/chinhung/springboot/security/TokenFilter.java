package idv.chinhung.springboot.security;

import java.io.IOException;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import idv.chinhung.springboot.sys_user.SysUser;
import idv.chinhung.springboot.sys_user.SysUserDAO;

@Component
public class TokenFilter extends GenericFilterBean {
	
	@Inject 
	private UserDetailsService userDetailsService;
	
	@Inject
	private SysUserDAO sysUserDAO;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String token = httpRequest.getHeader("TOKEN");
		
		Optional<String> username = getUsernameFromToken(token);
		
		if (username.isPresent() && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(username.get());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
		
		chain.doFilter(request, response);
	}

	private Optional<String> getUsernameFromToken(String token) {
		SysUser sysUser = sysUserDAO.findByToken(token);
		if (sysUser == null) {
			return Optional.empty();
		}
		return Optional.of(sysUser.getUserName());
	}
}
