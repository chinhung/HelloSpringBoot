package idv.chinhung.springboot.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String token = httpRequest.getHeader("TOKEN");
		if (!isValid(token)) {
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		chain.doFilter(request, response);
	}

	private boolean isValid(String token) {
		if (token == null) {
			return false;
		}
		if ("123456".equals(token)) {
			return true;
		}
		return false;
	}

}
