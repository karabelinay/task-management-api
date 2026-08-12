package com.belinay.task_management_api;

import com.belinay.task_management_api.entity.Task;
import com.belinay.task_management_api.repository.TaskRepository;
import com.belinay.task_management_api.service.TaskService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Test
    void taskOlusturmaTesti() {

        TaskRepository repository = mock(TaskRepository.class);
        TaskService service = new TaskService(repository);

        Task task = new Task();
        task.setTitle("Yeni Görev");
        task.setDescription("Test görevi");

        when(repository.save(task)).thenReturn(task);

        Task sonuc = service.createTask(task);

        assertEquals("Yeni Görev", sonuc.getTitle());
    }

    @Test
    void taskListelemeTesti() {

        TaskRepository repository = mock(TaskRepository.class);
        TaskService service = new TaskService(repository);

        when(repository.findAll()).thenReturn(List.of());

        List<Task> sonuc = service.getAllTasks();

        assertNotNull(sonuc);
    }
}