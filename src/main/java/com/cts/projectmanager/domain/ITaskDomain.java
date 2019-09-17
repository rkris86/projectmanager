package com.cts.projectmanager.domain;

import com.cts.projectmanager.dto.ParentTaskDTO;
import com.cts.projectmanager.dto.TaskDTO;

import java.util.List;

public interface ITaskDomain {
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
     * Method to edit Task
     *
     * @param task
     * @return
     */
    List<TaskDTO> editTask(TaskDTO task);

    /**
     * Method to delete Task
     *
     * @param task
     * @return
     */
    List<TaskDTO> deleteTask(TaskDTO task);


}