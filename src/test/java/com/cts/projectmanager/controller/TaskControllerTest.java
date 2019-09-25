package com.cts.projectmanager.controller;

import com.cts.projectmanager.dto.ParentTaskDTO;
import com.cts.projectmanager.dto.TaskDTO;
import com.cts.projectmanager.eo.ParentEO;
import com.cts.projectmanager.service.TaskServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class TaskControllerTest {
@MockBean
TaskController taskController;
@MockBean
    TaskServiceImpl taskService;
    List<ParentTaskDTO> parentTaskDTOS = new ArrayList<>();
    ParentTaskDTO parentTaskDTO = null;
    List<TaskDTO> taskDTOS = new ArrayList<>();
    TaskDTO taskDTO = null;
    @Before
    public void setUp() throws Exception {
        parentTaskDTO = new ParentTaskDTO(null,"Parent Task ");
        parentTaskDTOS.add(parentTaskDTO);

        taskDTO = new TaskDTO();
        taskDTO.setStatus("pending");
        taskDTO.setTaskId(1l);
        taskDTO.setStartDate("2019-09-22");
        taskDTO.setEndDate("2019-10-22");
        taskDTO.setTask("Task one");
        taskDTO.setPriority(10);
        taskDTO.setParentTask(parentTaskDTO);
        taskDTOS.add(taskDTO);
        taskController = new TaskController(taskService);
    }

    @Test
    public void fetchParentTask() {
        Mockito.when(taskService.fetchParentTasks()).thenReturn(parentTaskDTOS);
        assertNotNull(taskController.fetchParentTask());
    }

    @Test
    public void addParentTask() {
        Mockito.when(taskService.addParentTask(parentTaskDTO)).thenReturn(parentTaskDTOS);
        assertNotNull(taskController.fetchParentTask());
    }

    @Test
    public void fetchTasks() {
        Mockito.when(taskService.fetchTasks()).thenReturn(taskDTOS);
        assertNotNull(taskController.fetchTasks());
    }

    @Test
    public void testFetchTasks() {
        Mockito.when(taskService.fetchTask(1l)).thenReturn(taskDTOS);
        assertNotNull(taskController.fetchTasks(1l));
    }

    @Test
    public void completeTask() {
        Mockito.when(taskService.completeTask(1l)).thenReturn(taskDTOS);
        assertNotNull(taskController.completeTask(1l));
    }

    @Test
    public void addTask() {
        Mockito.when(taskService.addTask(taskDTO)).thenReturn(taskDTOS);
        assertNotNull(taskController.addTask(taskDTO));
    }

    @Test
    public void testAddParentTask() {
        Mockito.when(taskService.addParentTask(parentTaskDTO)).thenReturn(parentTaskDTOS);
        assertNotNull(taskController.addParentTask(parentTaskDTO));
    }
}