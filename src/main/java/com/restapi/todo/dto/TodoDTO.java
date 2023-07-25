package com.restapi.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long id;
    private String name;
    private String description;
    private String isDone;
    private String targetDate;
}
