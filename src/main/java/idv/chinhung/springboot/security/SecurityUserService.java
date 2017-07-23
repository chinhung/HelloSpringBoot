package idv.chinhung.springboot.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import idv.chinhung.springboot.sys_user.SysUser;
import idv.chinhung.springboot.sys_user.SysUserDAO;

@Service
public class SecurityUserService implements UserDetailsService {
	
	@Inject
	private SysUserDAO sysUserDAO;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		SysUser sysUser = sysUserDAO.findByUserName(userName);
		if (sysUser == null) {
			throw new UsernameNotFoundException(userName);
		}
		return new SecurityUser(sysUser);
	}

}
