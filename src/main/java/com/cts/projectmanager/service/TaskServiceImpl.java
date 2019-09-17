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
     * Method to edit Task
     *
     * @param task
     * @return
     */
    @Override
    public List<TaskDTO> editTask(TaskDTO task) {

        LOGGER.debug("editTask method start");
        List<TaskDTO> response = taskDomain.editTask(task);
        LOGGER.debug("editTask method end");
        return response;
    }

    /**
     * Method to delete Task
     *
     * @param task
     * @return
     */
    @Override
    public List<TaskDTO> deleteTask(TaskDTO task) {
        LOGGER.debug("deleteTask method start");
        List<TaskDTO> response = taskDomain.deleteTask(task);
        LOGGER.debug("deleteTask method end");
        return response;
    }
}
