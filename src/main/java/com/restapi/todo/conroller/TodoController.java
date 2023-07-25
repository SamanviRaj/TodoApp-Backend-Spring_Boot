package com.restapi.todo.conroller;

import com.restapi.todo.dto.TodoDTO;
import com.restapi.todo.entity.Todos;
import com.restapi.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
@CrossOrigin
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todos>> getTodos(){
        return new ResponseEntity<>(todoService.getTodos(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Todos> createTodo(@RequestBody TodoDTO todoDTO){
        return new ResponseEntity<>( todoService.createTodos(todoDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Todos> getTodoById(@PathVariable Long id){
        return new ResponseEntity<>( todoService.getTodoById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id){
        todoService.deleteById(id);
        return "Todo deleted Sucessfully";
    }

    @PutMapping("/update")
    public ResponseEntity<Todos> updateTodo(@RequestBody TodoDTO todoDTO){
        return new ResponseEntity<>( todoService.updateTodos(todoDTO), HttpStatus.OK);
    }

}
