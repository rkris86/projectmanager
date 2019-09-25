package com.cts.projectmanager.service;

import com.cts.projectmanager.domain.ITaskDomain;
import com.cts.projectmanager.domain.TaskDomainImpl;
import com.cts.projectmanager.dto.ParentTaskDTO;
import com.cts.projectmanager.dto.TaskDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements ITaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskDomainImpl.class);
    private ITaskDomain taskDomain;

    @Autowired
    public TaskServiceImpl(ITaskDomain taskDomain) {
        this.taskDomain = taskDomain;
    }

    /**
     * Method to fetch Parent Tasks;
     *
     * @return
     */
    @Override
    public List<ParentTaskDTO> fetchParentTasks() {
        LOGGER.debug("fetchParentTasks method start");
        List<ParentTaskDTO> response = taskDomain.fetchParentTasks();
        LOGGER.debug("fetchParentTasks method end");
        return response;
    }

    /**
     * Method to Add parent Tasks
     *
     * @param parentTask
     * @return
     */
    @Override
    public List<ParentTaskDTO> addParentTask(ParentTaskDTO parentTask) {
        LOGGER.debug("addParentTask method start");
        List<ParentTaskDTO> response = taskDomain.addParentTask(parentTask);
        LOGGER.debug("addParentTask method end");
        return response;
    }

    /**
     * Method to Fetch Tasks
     *
     * @return
     */
    @Override
    public List<TaskDTO> fetchTasks() {
        LOGGER.debug("fetchTasks method start");
        List<TaskDTO> response = taskDomain.fetchTasks();
        LOGGER.debug("fetchTasks method end");
        return response;
    }

    /**
     * Method to add Task
     *
     * @param task
     * @return
     */
    @Override
    public List<TaskDTO> addTask(TaskDTO task) {

        LOGGER.debug("addTask method start");
        List<TaskDTO> response = taskDomain.addTask(task);
        LOGGER.debug("addTask method end");
        return response;
    }


    /**
     * Method to fetch Tasks based on the project Id
     *
     * @param projectId
     * @return
     */
    @Override
    public List<TaskDTO> fetchTask(Long projectId) {
        LOGGER.debug("fetchTask method start" + projectId);
        List<TaskDTO> response = taskDomain.fetchTask(projectId);
        LOGGER.debug("fetchTask method end");
        return response;
    }

    /**
     * Method to complete Task based on the project Id
     *
     * @param taskId
     * @return
     */
    @Override
    public List<TaskDTO> completeTask(Long taskId) {
        LOGGER.debug("completeTask method start" + taskId);
        List<TaskDTO> response = taskDomain.completeTask(taskId);
        LOGGER.debug("completeTask method end");
        return response;
    }
}
