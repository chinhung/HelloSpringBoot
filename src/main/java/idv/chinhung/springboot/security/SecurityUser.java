package idv.chinhung.springboot.security;

import java.util.Collection;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import idv.chinhung.springboot.sys_user.SysUser;

import static java.util.stream.Collectors.*;

public class SecurityUser implements UserDetails {
	
	private SysUser sysUser;
	
	private List<GrantedAuthority> authorities;
	
	public SecurityUser(SysUser sysUser) {
		super();
		this.sysUser = sysUser;
		authorities = Stream.of("ROLE_" + this.sysUser.getUserName()).map(role -> {
			return new SimpleGrantedAuthority(role);
		}).collect(toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return sysUser.getPassword();
	}

	@Override
	public String getUsername() {
		return sysUser.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
