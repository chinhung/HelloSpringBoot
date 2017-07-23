package idv.chinhung.springboot;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Import;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import idv.chinhung.springboot.security.SecurityConfig;
import idv.chinhung.springboot.security.BeanConfig;

@Controller
@EnableAutoConfiguration
@Import({ BeanConfig.class, SecurityConfig.class})
public class Hello {

    @RequestMapping("/")
    @ResponseBody
    String home() {
    	System.out.println("request in");
        return "Hello World!";
    }
    
    @RequestMapping("/api/noRole")
    @ResponseBody
    String testNoRole() {
        return "No Role!";
    }
    
    @RequestMapping("/api/peter")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_peter')")
    String peter() {
        return "peter!";
    }
    
    @RequestMapping("/api/lisa")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_lisa')")
    String lisa() {
        return "lisa!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Hello.class, args);
    }
}
