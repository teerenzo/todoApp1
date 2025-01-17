package com.renzo.springboot.todoApp1.todo;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}


	@RequestMapping("todo-list")
	public String todoList(ModelMap model) {
		model.put("todos", todoService.findByUsername(getLoggedinUsername()));
		return "todoList";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String ShowaddTodo(ModelMap model) {
		model.put("todo", new Todo(0,getLoggedinUsername(),"",LocalDate.now().plusYears(1),false));
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "todo";
		}
		todoService.addTodo(getLoggedinUsername(),todo.getDescription(), LocalDate.now().plusYears(1));
		return "redirect:todo-list";
	}
	
	@RequestMapping(value="delete-todo", method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:todo-list";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id,ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult res) {
		if(res.hasErrors()) {
			return "todo";
		}
		
		todo.setUsername(getLoggedinUsername());
		
		todoService.updateTodo(todo);
		
		return "redirect:todo-list";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
	
	
	
	

}
