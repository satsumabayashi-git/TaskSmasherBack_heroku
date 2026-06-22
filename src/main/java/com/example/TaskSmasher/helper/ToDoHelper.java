package com.example.TaskSmasher.helper;

import com.example.TaskSmasher.entity.ToDo;
import com.example.TaskSmasher.form.ToDoForm;

public class ToDoHelper {

	public static ToDo convertToDo(ToDoForm form) {
		ToDo todo = new ToDo();
		todo.setId(form.getId());
		todo.setTodo(form.getTodo());
		todo.setDetail(form.getDetail());
		return todo;
	}

	public static ToDoForm convertToDoForm(ToDo todo) {
		ToDoForm form = new ToDoForm();
		form.setId(todo.getId());
		form.setTodo(todo.getTodo());
		form.setDetail(todo.getDetail());
		// 更新画面設定
		form.setIsNew(false);
		return form;
	}

}
