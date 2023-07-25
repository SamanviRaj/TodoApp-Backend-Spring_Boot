package com.restapi.todo.service;

import com.restapi.todo.dto.TodoDTO;
import com.restapi.todo.entity.Todos;

import java.util.List;

public interface TodoService {

    public List<Todos> getTodos();

    public Todos createTodos(TodoDTO todoDTO);

    public Todos getTodoById(Long id);

    public String deleteById(Long id);

    public Todos updateTodos(TodoDTO todoDTO);
}
