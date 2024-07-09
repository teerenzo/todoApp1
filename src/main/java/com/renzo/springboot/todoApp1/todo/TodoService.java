package com.renzo.springboot.todoApp1.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int count=0;
	
	static {
		todos.add(new Todo(++count, "codeit","learn java",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++count, "codeit","learn aws",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++count, "codeit","learn fullstack java",LocalDate.now().plusYears(1),false));
	}
	
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String username,String description, LocalDate date) {
		todos.add(new Todo(++count,username,description,date,false));
	}
	
	public void deleteTodo(int id) {
		todos.removeIf(todo -> todo.getId()==id);
	}

	public Todo findById(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	
	}
	
	public void updateTodo(Todo todo) {
	     deleteTodo(todo.getId());
	     todos.add(todo);
	}
	

}
