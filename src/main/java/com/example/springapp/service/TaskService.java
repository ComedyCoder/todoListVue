package com.example.springapp.service;

import com.example.springapp.model.Task;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

//CRUD operations
@Service
public class TaskService {

    public static final String COL_NAME = "tasks";

    public String saveTaskDetails(Task newTask) throws InterruptedException, ExecutionException {
        System.out.println(newTask.toString());
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(newTask.getId()).set(newTask);
        return "Task - " + newTask.getName() + " was added at\n " +  collectionsApiFuture.get().getUpdateTime();
    }

    public String getTaskDetails(String docID) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(docID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        if(document.exists()) {
            return "Got Task ID " +  document.getId() + "With name " + document.getString("name");
        }else {
            return null;
        }
    }

    public HashMap<String, Task> getAllTasks() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
       // asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();
       // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        HashMap<String, Task>  taskMap = new HashMap();
        for (QueryDocumentSnapshot doc : documents) {
            taskMap.put(doc.getId(), new Task(doc.getId(), (String) doc.get("name"), (String) doc.get("time"), (String) doc.get("icon"), (Boolean) doc.get("completed")));
        }
        System.out.println(taskMap.size() + " tasks were collected for the user");
        return taskMap;
    }
    public String deleteTask(String docID) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
         dbFirestore.collection(COL_NAME).document(docID).delete();
        return "Task ID "+ docID +" has been deleted";
    }
    public void updateStatus(String docID, boolean bool) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
       dbFirestore.collection(COL_NAME).document(docID).update("completed", bool);
    }
    public HashMap<String, Task> filterTasks(String filter) throws ExecutionException, InterruptedException {
        HashMap<String, Task> allTasks = this.getAllTasks();
        HashMap<String, Task> filteredTasks = new HashMap<>();
        switch(filter) {
            case "all":
                return allTasks;
            case "completed":
                allTasks.forEach((key, value) -> {
                  if(value.isCompleted())  {
                      filteredTasks.put(key,value);
                  }
                });
                break;
            case "onGoing":
                allTasks.forEach((key, value) -> {
                    if(!value.isCompleted())  {
                        filteredTasks.put(key,value);
                    }
                });
                break;
            case "important":
                allTasks.forEach((key, value) -> {
                    if(value.getIcon().equals("star"))  {
                        filteredTasks.put(key,value);
                    }
                });
        }
        return filteredTasks;
    }
}
