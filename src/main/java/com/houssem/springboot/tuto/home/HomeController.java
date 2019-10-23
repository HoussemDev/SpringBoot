package com.houssem.springboot.tuto.home;

import com.houssem.springboot.tuto.todos.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/")
    public String greeting(){
        return "hello You Houssem";
    }

    @GetMapping(value = "/{name}")
    public String greetingWithName(@PathVariable String name){
        return String.format("Hello"+ name);

    }
}
