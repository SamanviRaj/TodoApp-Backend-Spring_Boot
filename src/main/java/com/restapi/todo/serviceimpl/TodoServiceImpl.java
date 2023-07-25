package com.restapi.todo.serviceimpl;

import com.restapi.todo.dto.TodoDTO;
import com.restapi.todo.entity.Todos;
import com.restapi.todo.repository.TodoRepository;
import com.restapi.todo.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
@Service
@AllArgsConstructor
@NoArgsConstructor
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Override
    public List<Todos> getTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todos createTodos(TodoDTO todoDTO) {

        try{
        Todos todosEntity = new Todos();
        todosEntity.setId(todoDTO.getId());
        todosEntity.setName(todoDTO.getName());
        todosEntity.setDescription(todoDTO.getDescription());
        todosEntity.setIsDone(todoDTO.getIsDone());

        String startDate=todoDTO.getTargetDate();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date sqlTargetDate = new java.sql.Date(date.getTime());
        todosEntity.setTargetDate(sqlTargetDate);

        return todoRepository.save(todosEntity);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Todos getTodoById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public String deleteById(Long id) {
        todoRepository.deleteById(id);
        return "Todo deleted Sucessfully";
    }

    @Override
    public Todos updateTodos(TodoDTO todoDTO) {

        try{
            Todos todosEntity = new Todos();
            todosEntity.setId(todoDTO.getId());
//            todosEntity.setName(todoDTO.getName());
            todosEntity.setDescription(todoDTO.getDescription());
//             todosEntity.setIsDone(todoDTO.getIsDone());

            String targetDate=todoDTO.getTargetDate();
            System.out.println("date !!"+targetDate);
            Date sqlTargetDate= Date.valueOf(targetDate);
           /* System.out.println("date !!"+startDate);
            SimpleDateFormat sdf1 = new SimpleDateFormat("DD-MM-YYYY");
            java.util.Date date = sdf1.parse(startDate);
            java.sql.Date sqlTargetDate = new java.sql.Date(date.getTime());*/
            todosEntity.setTargetDate(sqlTargetDate);

            return todoRepository.save(todosEntity);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
