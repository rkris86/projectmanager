package com.cts.projectmanager.service;

import com.cts.projectmanager.dto.ParentTaskDTO;
import com.cts.projectmanager.dto.TaskDTO;

import java.util.List;

public interface ITaskService {
    /**
     * Method to fetch Parent Tasks;
     *
     * @return
     */
    List<ParentTaskDTO> fetchParentTasks();

    /**
     * Method to Add parent Tasks
     *
     * @param parentTask
     * @return
     */
    List<ParentTaskDTO> addParentTask(ParentTaskDTO parentTask);

    /**
     * Method to Fetch Tasks
     *
     * @return
     */
    List<TaskDTO> fetchTasks();

    /**
     * Method to add Task
     *
     * @param task
     * @return
     */
    List<TaskDTO> addTask(TaskDTO task);

    /**
     * Method to fetch Tasks based on the project Id
     * @param projectId
     * @return
     */
    List<TaskDTO> fetchTask(Long projectId);

    /**
     * Method to complete Task based on the project Id
     * @param taskId
     * @return
     */
    List<TaskDTO> completeTask(Long taskId);
}
