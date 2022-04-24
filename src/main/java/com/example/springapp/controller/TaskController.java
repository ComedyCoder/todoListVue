package com.example.springapp.controller;

import com.example.springapp.model.Task;
import com.example.springapp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    TaskService taskService = new TaskService();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @PostMapping("/create")
    public String create(@RequestBody Task task) throws ExecutionException, InterruptedException {
        return taskService.saveTaskDetails(new Task(task.getId(), task.getName(), task.getTime(), task.getIcon(), task.isCompleted()));
    }
    @GetMapping("/get")
    public String get(@RequestParam String docID) throws ExecutionException, InterruptedException {
        return taskService.getTaskDetails(docID);
    }
    @GetMapping("/getAll")
    public HashMap<String, Task> getAll() throws ExecutionException, InterruptedException {
      return taskService.getAllTasks();
    }
    @DeleteMapping("/delete")
    public String delete(@RequestParam String docID) throws ExecutionException, InterruptedException {
        return taskService.deleteTask(docID);
    }

    @PutMapping("/updateStatus")
    public void updateStatus(@RequestParam String docID, boolean bool) throws ExecutionException, InterruptedException {
         taskService.updateStatus(docID, bool);
    }
    @GetMapping("/filterBy")
    public HashMap<String, Task> filterBy(@RequestParam String filter) throws ExecutionException, InterruptedException {
        return taskService.filterTasks(filter);
    }
}

