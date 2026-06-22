package com.example.TaskSmasher.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.TaskSmasher.entity.ToDo;
import com.example.TaskSmasher.repository.ToDoMapper;
import com.example.TaskSmasher.service.ToDoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
	
	private final ToDoMapper toDoMapper;
	private final ObjectMapper objectMapper;
	
	@Override
	public String findAllToDoIntoJson() {
		try {
			String jsonToDos = objectMapper.writeValueAsString(findAllToDo());
			return jsonToDos;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "failed";
		}
	}
	
	

	@Override
	public List<ToDo> findAllToDo() {
		return toDoMapper.selectAll();
	}

	@Override
	public ToDo findByIdToDo(Integer id) {
		return toDoMapper.selectById(id);
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
	
	

}
