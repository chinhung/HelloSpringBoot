package idv.chinhung.springboot;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@Import({ SecurityConfig.class })
public class Hello {

    @RequestMapping("/")
    @ResponseBody
    String home() {
    	System.out.println("request in");
        return "Hello World!";
    }
    
    @RequestMapping("/auth-ed")
    @ResponseBody
    String authenticated() {
        return "Authenticated!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Hello.class, args);
    }
}
