package com.example.TaskSmasher.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.TaskSmasher.entity.ToDo;

@Mapper
public interface ToDoMapper {
	List<ToDo> selectAll();
	ToDo selectById(@Param("id") Integer id);
	List<ToDo> selectIncomplete();
	List<ToDo> selectComplete();
	void insert(ToDo toDo);
	void update(ToDo toDo);
	void delete(@Param("id") Integer id);
	void complete(@Param("id") Integer id);
	void incomplete(@Param("id") Integer id);

}
