package com.painandsuffering.controller;

import org.springframework.web.bind.annotation.*;
import java.utils.Arrays;
/**
 * Created by mrflo on 26.05.2017.
 */
@RestController
public class ShopController{
    private
    @RequestMapping("/shop")
    String home() {
        return "Hello, add your name to request please. Like /welcome?name=XXX";
    }
    @RequestMapping("/welcome/{username}")
    String welcome(@PathVariable String username){
        return String.format("Your welcome, %s", username);
    }
}
