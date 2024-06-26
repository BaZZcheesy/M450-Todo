package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Task;
import com.example.repository.TaskRepository;

@RestController
@CrossOrigin( origins = "http://localhost:3000/")
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
	private TaskRepository taskrepo;

	@GetMapping("/")
	public List<Task> getTasks() {
		return taskrepo.findAll();
	}

	@GetMapping("/hello/{param}")
	public String helloMessage(@PathVariable (value = "param") String param) {
		return "Hello " + param;
	}

	@GetMapping("/{param1}/{param2}")
	public int calcTwoNumbers(@PathVariable (value = "param1") int param1, @PathVariable (value = "param2") int param2) {
		return param1 * param2;
	}

	@PostMapping("/add")
	public ResponseEntity<Task> addTask(@RequestBody Task task) {
		task = taskrepo.save(task);
		return ResponseEntity.ok(task);
	}

	@PostMapping("/delete")
	public String delTask(@RequestBody Task taskToFind) {
		Task task = taskrepo.findByTaskdescription(taskToFind.getTaskdescription());
		if (task != null) {
			taskrepo.delete(task);
			return "deleted: " + task.toString();
		}
		
		return "deletion failed";
	}
}
