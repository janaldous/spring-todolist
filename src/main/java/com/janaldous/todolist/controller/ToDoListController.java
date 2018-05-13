package com.janaldous.todolist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.data.TaskListService;
import com.janaldous.todolist.entity.Task;
import com.janaldous.todolist.repository.TaskJdbcRepository;

@Controller
@RequestMapping("todolist")
public class ToDoListController {
	
	/**
	 * Repo for lists
	 */
	@Autowired
	TaskJdbcRepository repository;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String listTasks(Model model) {
		model.addAttribute("taskList", repository.findAll());
		return "list";
	}
	
	@RequestMapping(value = "/task", method = RequestMethod.GET)
    public String taskForm(Model model, @ModelAttribute("task") Task task) {
        model.addAttribute("task", task);
        return "task";
    }
    
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public RedirectView submitTask(@ModelAttribute Task task, 
    		WebRequest request, SessionStatus status) {
    	TaskListService.addTask(task);
    	status.setComplete();
        request.removeAttribute("task", WebRequest.SCOPE_SESSION);
        return new RedirectView("list");
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public void deleteTask(@RequestParam("id") int id) {
    	TaskListService.deleteTask(id);
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView editTask(@ModelAttribute("task") Task task, 
    		@RequestParam("id") long id, Model model) {
    	task = repository.findById(id);
    	return new ModelAndView("edit", "task", task);
    }
    
    @RequestMapping(value = "editTask", method = RequestMethod.POST)
    public String editTaskPost(@Valid @ModelAttribute("task") Task task,
    		BindingResult result, WebRequest request, SessionStatus status) {
    	  	
    	if(result.hasErrors()) {
    		return "edit.jsp?id="+task.getId();
    	}
    	System.out.println(task.getId());
    	repository.update(task);
    	
    	return "redirect:list";
    }
    
    @RequestMapping(value= "done", method = RequestMethod.GET)
    @ResponseBody
    public void doneTask(@RequestParam("id") long id, @RequestParam("done") boolean done) {
    	repository.markDone(id, done);
    }
}
