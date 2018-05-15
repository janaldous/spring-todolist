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

import com.janaldous.todolist.entity.Task;
import com.janaldous.todolist.repository.TaskRepository;

@Controller
@RequestMapping("todolist")
public class ToDoListController {
	
	/**
	 * Repository for a to do list
	 */
	@Autowired
	TaskRepository repository;
	
	/**
	 * Home page showing list of all tasks
	 * @param model
	 * @return JSP filename
	 */
	@RequestMapping(value = "/")
	public String listTasks(Model model) {
		model.addAttribute("taskList", repository.findAll());
		
		return "todolist/list";
	}
	
	/**
	 * 
	 * @param model
	 * @param task
	 * @return
	 */
	@RequestMapping(value = "/task", method = RequestMethod.GET)
    public String addTask(Model model, @ModelAttribute("task") Task task) {
        model.addAttribute("task", task);
        
        return "todolist/task";
    }
    
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public RedirectView submitNewTask(@ModelAttribute Task task) {
    	repository.insert(task);

        return new RedirectView("");
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editTask(@ModelAttribute("task") Task task, 
    		@RequestParam("id") long id, Model model) {
    	task = repository.findById(id);
    	
    	return new ModelAndView("todolist/edit", "task", task);
    }
    
    @RequestMapping(value = "/editTask", method = RequestMethod.POST)
    public String submitEditTask(@Valid @ModelAttribute("task") Task task,
    		BindingResult result) {
    	  	
    	//@ControllerAdvice
    	//@ExceptionHandler
    	//custom exception (preferably runtime)
    	if(result.hasErrors()) {
    		return "edit.jsp?id="+task.getId();
    	}
    	System.out.println(task.getId());
    	repository.update(task);
    	
    	return "redirect:";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public void deleteTask(@RequestParam("id") long id) {
    	repository.deleteById(id);
    }
    
    @RequestMapping(value= "/done", method = RequestMethod.GET)
    @ResponseBody
    public void markDoneTask(@RequestParam("id") long id, @RequestParam("done") boolean done) {
    	repository.markDone(id, done);
    }
}
