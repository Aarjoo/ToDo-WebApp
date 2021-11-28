package com.tcs.todoapp.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tcs.todoapp.Model.ToDo;
import com.tcs.todoapp.Service.TODOService;

@Controller
@SessionAttributes("username")
public class TODOController {
	
	@InitBinder
	public void dateBinder(WebDataBinder binder)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	@Autowired 
	TODOService todoService;
	
	@RequestMapping("/todos-list")
	public String getToDosList(ModelMap model)
	{
		System.out.println((String) model.get("username"));
		model.addAttribute("todos", todoService.getToDos((String) model.get("username")));
		return "todos-list";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String addToDo(ModelMap model)
	{
		model.addAttribute("todo",new ToDo());
		return "add-todo";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addToDoInList(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println("validation errors !");
			return "add-todo";
		}
		todoService.addTodo(todo.getDesc(), (String)model.get("username"), todo.getDate());
		return "redirect:/todos-list";
	}
	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteToDo(@RequestParam int id) throws Exception
	{
		todoService.deleteToDo(id);
		return "redirect:/todos-list";
	}
	
	@RequestMapping("/update-todo")
	public String showUpdateToDoPage(int id, ModelMap model)
	{
		ToDo todo = todoService.getToDo(id);
		model.addAttribute("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result
			,ModelMap model
			)
	{
		if(result.hasErrors())
		{
			return "add-todo";
		}
		System.out.println(todo.getId());
		todo.setUser((String) model.get("username"));
		todo.setDate(todo.getDate());
		todoService.updateToDo(todo);
		return "redirect:/todos-list";
	}
	
}
