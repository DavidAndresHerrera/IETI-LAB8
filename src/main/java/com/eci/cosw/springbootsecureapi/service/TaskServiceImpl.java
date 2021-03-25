package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private List<Task> tasks = new ArrayList<>();

    @Autowired
    public TaskServiceImpl()
    {
        tasks.add(new Task(1,"En construccion","David Herrera","In progress",new Date()));
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public Task findTaskById(String id) throws Exception {
        for (Task i:tasks){
            if (i.getId().equals(Integer.getInteger(id))){
                return i;
            }
        }
        return null;
    }

    @Override
    public void createTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void delTaskById(String id) throws Exception {
        for (int i = 0; i<tasks.size();i++){
            if (tasks.get(i).getId().equals(Integer.getInteger(id))){
                tasks.remove(i);
                break;
            }
        }
    }
}
