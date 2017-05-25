/**
 * Created by mrflo on 26.05.2017.
*/
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Welcome {

    @RequestMapping("/")
    String home() {
        return "Hello, add your name to request please. Like /welcome?name=XXX";
    }
    @RequestMapping("/welcome")
    String welcome(@RequestParam(value="name", defaultValue="friend") String name){
        return String.format("Your welcome, %s", name);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Welcome.class, args);
    }

}