package com.houssem.springboot.tuto.todos;

import com.houssem.springboot.tuto.error.ConflictException;
import com.houssem.springboot.tuto.error.NotFoundException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

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

        try{
            return todoRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new NotFoundException(String.format("no record with the Id [%s] was found in our database", id));
        }
    }

    public Todo save(Todo todo){
        if(todoRepository.findByTitle(todo.getTitle()) != null ) {
            throw  new ConflictException("Another record with the same title existe");
        }
        return todoRepository.insert(todo);
    }

    public void delete(String id){
        todoRepository.deleteById(id);
    }
}
