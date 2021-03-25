package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/task" )
public class TaskController {


        @Autowired
        TaskService tasks;

        @RequestMapping(path = "/addTask", method = RequestMethod.POST)
        public ResponseEntity<?> nreTask(@RequestBody Task task){
            try {
                tasks.createTask(task);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (Exception ex) {
                return new ResponseEntity<>(null, null);
            }
        }


        @RequestMapping(path = "/delet/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<?>  delteTask(@PathVariable(name = "id") String id) {
            try {
                tasks.delTaskById(id);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (Exception ex) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }

        @RequestMapping( method = RequestMethod.GET)
        public ResponseEntity<?> getAllTasks(){
            try{
                return new ResponseEntity<>(tasks.getTasks(),HttpStatus.ACCEPTED);
            }catch (Exception ex){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }


}
