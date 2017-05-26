package com.painandsuffering.web;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
/**
 * Created by mrflo on 26.05.2017.
 */
@RestController
public class WelcomeController{

        @RequestMapping("/")
        String home() {
            return "Hello, add your name to request please. Like /welcome?name=XXX";
        }
        @RequestMapping("/welcome/{username}")
        String welcome(@PathVariable String username){
            return String.format("Your welcome, %s", username);
        }
}
