package com.cts.projectmanager.controller;

import com.cts.projectmanager.dto.ParentTaskDTO;
import com.cts.projectmanager.dto.TaskDTO;
import com.cts.projectmanager.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class TaskController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);
    private ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/parent", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<ParentTaskDTO> fetchParentTask() {
        LOGGER.debug("fetchParentTask method start");
        List<ParentTaskDTO> response = taskService.fetchParentTasks();
        LOGGER.debug("fetchParentTask method end");
        return response;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/parent", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<ParentTaskDTO> addParentTask(@RequestBody ParentTaskDTO parentTask) {
        LOGGER.debug("fetchParentTask method start");
        List<ParentTaskDTO> response = taskService.addParentTask(parentTask);
        LOGGER.debug("fetchParentTask method end");
        return response;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/task", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<TaskDTO> fetchTasks() {
        LOGGER.debug("fetchTasks method start");
        List<TaskDTO> response = taskService.fetchTasks();
        LOGGER.debug("fetchTasks method end");
        return response;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<TaskDTO> fetchTasks(@PathVariable("id") Long projectId) {
        LOGGER.debug("fetchTasks method start");
        System.out.println("project Id is : "+projectId);
        List<TaskDTO> response = taskService.fetchTask(projectId);
        LOGGER.debug("fetchTasks method end");
        return response;
    }
    @CrossOrigin("*")
    @RequestMapping(value = "/task/complete/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<TaskDTO> completeTask(@PathVariable("id") Long taskId) {
        LOGGER.debug("completeTask method start");
        List<TaskDTO> response = taskService.completeTask(taskId);
        LOGGER.debug("completeTask method end");
        return response;
    }
    @CrossOrigin("*")
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<TaskDTO> addTask(@RequestBody TaskDTO task) {
        LOGGER.debug("fetchTasks method start");
        List<TaskDTO> response = taskService.addTask(task);
        LOGGER.debug("fetchTasks method end");
        return response;
    }
}
