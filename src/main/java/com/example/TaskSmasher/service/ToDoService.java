package com.example.TaskSmasher.service;

import java.util.List;

import com.example.TaskSmasher.entity.ToDo;

public interface ToDoService {
	
	List<ToDo> findAllToDo();
	ToDo findByIdToDo(Integer id);
	List<ToDo> findIncompleteToDo();
	List<ToDo> findCompleteToDo();
	void insertToDo(ToDo toDo);
	void updateToDo(ToDo toDo);
	void deleteToDo(Integer id);
	void completeToDo(Integer id);
	void incompleteToDo(Integer id);

}
