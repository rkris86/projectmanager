package com.cts.projectmanager.service;

import com.cts.projectmanager.controller.TaskController;
import com.cts.projectmanager.domain.ITaskDomain;
import com.cts.projectmanager.dto.ParentTaskDTO;
import com.cts.projectmanager.dto.TaskDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
public class TaskServiceImplTest {
@MockBean
        TaskServiceImpl taskService;
@MockBean
    ITaskDomain taskDomain;

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
        taskService = new TaskServiceImpl(taskDomain);
    }

    @Test
    public void fetchParentTasks() {
        Mockito.when(taskDomain.fetchParentTasks()).thenReturn(parentTaskDTOS);
        assertNotNull(taskService.fetchParentTasks());
    }

    @Test
    public void addParentTask() {
        Mockito.when(taskDomain.addParentTask(parentTaskDTO)).thenReturn(parentTaskDTOS);
        assertNotNull(taskService.addParentTask(parentTaskDTO));
    }

    @Test
    public void fetchTasks() {
        Mockito.when(taskDomain.fetchTasks()).thenReturn(taskDTOS);
        assertNotNull(taskService.fetchTasks());
    }

    @Test
    public void addTask() {
        Mockito.when(taskDomain.addTask(taskDTO)).thenReturn(taskDTOS);
        assertNotNull(taskService.addTask(taskDTO));
    }

    @Test
    public void fetchTask() {
        Mockito.when(taskDomain.fetchTask(1l)).thenReturn(taskDTOS);
        assertNotNull(taskService.fetchTask(1l));
    }

    @Test
    public void completeTask() {
        Mockito.when(taskDomain.completeTask(1l)).thenReturn(taskDTOS);
        assertNotNull(taskService.completeTask(1l));
    }
}