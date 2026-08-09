package com.belinay.task_management_api;

import com.belinay.task_management_api.service.TaskService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void taskOlusturmaTesti() {
        TaskService service = new TaskService();

        String sonuc = service.createTask("Yeni Görev");

        assertEquals("Yeni Görev", sonuc);
    }

    @Test
    void taskTamamlamaTesti() {
        TaskService service = new TaskService();

        boolean sonuc = service.completeTask();

        assertTrue(sonuc);
    }
}
