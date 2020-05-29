package cl.tbd.back.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cl.tbd.back.model.Task;

public interface TaskDao {
    
    int insertTask(UUID id, Task task);

    default int insertTask(Task task) {
        UUID id = UUID.randomUUID();
        return insertTask(id, task);
    }

    List<Task> selectAllTasks();

    Optional<Task> selectTaskById(UUID id);

    int updateTaskNameById(UUID id, Task task);

    int updateTaskDescriptionById(UUID id, Task task);

    int updateTaskRequieredVolunteersById(UUID id, Task task);

    int updateTaskFinishDateById(UUID id, Task task);

    int deleteTaskById(UUID id);
    
}