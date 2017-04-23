package idv.chinhung.springboot;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class Hello {

    @RequestMapping("/")
    @ResponseBody
    String home() {
    	System.out.println("request in");
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Hello.class, args);
    }
}
