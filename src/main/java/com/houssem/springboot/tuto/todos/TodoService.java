package com.houssem.springboot.tuto.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {


    @Autowired
    private TodoRepository todoRepository;

    /**
     *  Get all todos
     * @return List of todo
     */
    public List<Todo> findAll() {

       return todoRepository.findAll();
    }

    public Todo getById(String id) {

        return todoRepository.findById(id).get();
    }

    public Todo save(Todo todo){
        return todoRepository.insert(todo);
    }

    public void delete(String id){
        todoRepository.deleteById(id);
    }
}
