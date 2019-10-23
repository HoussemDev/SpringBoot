package com.houssem.springboot.tuto.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {


    @Autowired
    private TodoService todoService;


    @GetMapping(value = {"", "/"})
    public List<Todo> getAllTodos() {
        return todoService.findAll();

    }
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable int id){
        return todoService.getById(id);
    }

    @PostMapping(value= {"","/"})
    public Todo createNewTodo(@RequestBody Todo todo){

        if(todoService.save(todo)){
            return todo;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable int id){
        todoService.delete(id);
    }

}
