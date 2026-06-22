package com.example.TaskSmasher.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.TaskSmasher.entity.ToDo;
import com.example.TaskSmasher.service.ToDoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

	private final ToDoService toDoService;
	private final ObjectMapper objectMapper;

	@GetMapping
	@ResponseBody
	public String list(Model model) {
		try {
			String jsonToDos = objectMapper.writeValueAsString(toDoService.findAllToDo());
			System.out.println("生成されたJSON: " + jsonToDos);
			return jsonToDos;
		} catch (IOException e) {
			e.printStackTrace();
			return "failed";
		}
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public String detail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		ToDo ToDo = toDoService.findByIdToDo(id);
		if (ToDo != null) {
			try {
				String jsonToDo = objectMapper.writeValueAsString(ToDo);
				System.out.println("生成されたJSON: " + jsonToDo);
				return jsonToDo;
			} catch (IOException e) {
				e.printStackTrace();
				return "failed";
			}
//			model.addAttribute("todo", toDoService.findByIdToDo(id));
//			return "todo/detail";
		} else {
			return "対象データがありません";
//			attributes.addFlashAttribute("errorMessage", "対象データがありません");
//			return "redirect:/todos";
		}
	}
	
	
	
	
	
//	@GetMapping
//	public String list(Model model) {
//		model.addAttribute("todos", toDoService.findAllToDo());
//		return "todo/list";
//	}
//
//	@GetMapping("/{id}")
//	public String detail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
//		ToDo ToDo = toDoService.findByIdToDo(id);
//		if (ToDo != null) {
//			model.addAttribute("todo", toDoService.findByIdToDo(id));
//			return "todo/detail";
//		} else {
//			attributes.addFlashAttribute("errorMessage", "対象データがありません");
//			return "redirect:/todos";
//		}
//	}
//
//	@GetMapping("/form")
//	public String newToDo(@ModelAttribute ToDoForm form) {
//		form.setIsNew(true);
//		return "todo/form";
//	}
//
//	@PostMapping("/save")
//	public String create(@Validated ToDoForm form, BindingResult bindingResult, RedirectAttributes attributes) {
//		if (bindingResult.hasErrors()) {
//			form.setIsNew(true);
//			return "todo/form";
//		}
//		ToDo toDo = ToDoHelper.convertToDo(form);
//		toDoService.insertToDo(toDo);
//		attributes.addFlashAttribute("message", "新しいToDoが作成されました");
//		return "redirect:/todos";
//	}
//
//	@GetMapping("/edit/{id}")
//	public String edit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
//		ToDo target = toDoService.findByIdToDo(id);
//		if (target != null) {
//			ToDoForm form = ToDoHelper.convertToDoForm(target);
//			model.addAttribute("toDoForm", form);
//			return "/todo/form";
//		} else {
//			attributes.addFlashAttribute("errorMessage", "対象データがありません");
//			return "redirect:/todos";
//		}
//	}
//	
//	@PostMapping("/update")
//	public String update(@Validated ToDoForm form, BindingResult bindingResult, RedirectAttributes attributes) {
//		if (bindingResult.hasErrors()) {
//			form.setIsNew(false);
//			return "todo/form";
//		}
//		ToDo toDo = ToDoHelper.convertToDo(form);
//		toDoService.updateToDo(toDo);
//		attributes.addFlashAttribute("message", "ToDoが更新されました");
//		return "redirect:/todos";
//	}
//	
//	@PostMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
//		toDoService.deleteToDo(id);
//        attributes.addFlashAttribute("message", "ToDoが削除されました");
//        return "redirect:/todos";
//    }


}
