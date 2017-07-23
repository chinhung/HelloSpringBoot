package idv.chinhung.springboot.sys_user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface SysUserDAO extends JpaRepository<SysUser, Long>{

	SysUser findByUserName(String userName);
	
	SysUser findByToken(String token);
}
