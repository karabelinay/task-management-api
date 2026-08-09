package com.belinay.task_management_api.service;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public String createTask(String title) {
        return title;
    }

    public boolean completeTask() {
        return true;
    }
}