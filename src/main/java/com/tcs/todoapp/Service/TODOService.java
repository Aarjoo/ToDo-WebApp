package com.tcs.todoapp.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tcs.todoapp.Model.ToDo;

@Service
@SessionAttributes("username")
public class TODOService {
	
	private static List<ToDo> list = new ArrayList<>();
	
	static {
		System.out.println("static block executed of ToDoService class!");
		list.add(new ToDo(1,"Admin","Learn Spring",false,new Date()));	
		list.add(new ToDo(2,"Admin","Learn React",false,new Date()));	
		list.add(new ToDo(3,"Admin","Take Break",false,new Date()));	
		list.add(new ToDo(4,"Admin","Attend Meeting",false,new Date()));	
	}
	
	int todoCount = 5;
	public List<ToDo> getToDos(String username)
	{
		List<ToDo> filterList = new ArrayList<>();
		for(ToDo todo : list)
		{
			if(todo.getUser().equals(username))
			{
				filterList.add(todo);
			}
		}
		return filterList;
	}
	
	public void addTodo(String todo, String username, Date date)
	{
		list.add(new ToDo(todoCount++,username,todo,false,date));
	}
	
	public void deleteToDo(int id) throws Exception
	{
		if(id == 1)
		{
			throw new Exception("there is an exception");
		}
		list.removeIf(t -> t.getId()==id);
	
	}
	public ToDo getToDo(int id)
	{
		return list.stream().filter(t -> t.getId()==id).findFirst().orElse(null);
	}
	
	public void updateToDo(ToDo todo)
	{
		list.removeIf(t -> t.getId() == todo.getId());
		list.add(todo);
//		deleteToDo(todo.getId());
//		list.add(todo);
	//	list.set(todo.getId()-1, todo);	
	}
}
