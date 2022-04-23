package com.example.springapp.controller;

import com.example.springapp.model.Task;
import com.example.springapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    TaskService taskService = new TaskService();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @PostMapping("/create")
    public String create(@RequestBody Task task) throws ExecutionException, InterruptedException {
        return taskService.saveTaskDetails(new Task(task.getId(), task.getName(), task.getTime(), task.getIcon()));
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
//    @PutMapping("/update")
//    public String update(@RequestParam String docID, @RequestBody Task task) throws ExecutionException, InterruptedException {
//        return taskService.updateTaskDetails(docID, task);
//    }


}

