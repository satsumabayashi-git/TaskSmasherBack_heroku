package com.example.TaskSmasher.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.TaskSmasher.entity.ToDo;
import com.example.TaskSmasher.repository.ToDoMapper;
import com.example.TaskSmasher.service.ToDoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
	
	private final ToDoMapper toDoMapper;
	private final ObjectMapper objectMapper;

	@Override
	public List<ToDo> findAllToDo() {
		return toDoMapper.selectAll();
	}

	@Override
	public ToDo findByIdToDo(Integer id) {
		return toDoMapper.selectById(id);
	}
	
	@Override
	public List<ToDo> findIncompleteToDo() {
		return toDoMapper.selectIncomplete();
	}
	
	@Override
	public List<ToDo> findCompleteToDo() {
		return toDoMapper.selectComplete();
	}

	@Override
	public void insertToDo(ToDo toDo) {
		toDoMapper.insert(toDo);
	}

	@Override
	public void updateToDo(ToDo toDo) {
		toDoMapper.update(toDo);
	}

	@Override
	public void deleteToDo(Integer id) {
		toDoMapper.delete(id);
	}
	
	@Override
	public void completeToDo(Integer id) {
		toDoMapper.complete(id);
	}
	
	@Override
	public void incompleteToDo(Integer id) {
		toDoMapper.incomplete(id);
	}

}
