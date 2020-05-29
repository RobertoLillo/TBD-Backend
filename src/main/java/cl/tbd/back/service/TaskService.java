package cl.tbd.back.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.tbd.back.dao.TaskDao;
import cl.tbd.back.model.Task;

@Service
public class TaskService {

    private final TaskDao taskdao;

    @Autowired
    public TaskService(@Qualifier("postgresTask") TaskDao taskdao) {
        this.taskdao = taskdao;
    }

    public int insertTask(Task task) {
        return taskdao.insertTask(task);
    }

    public List<Task> selectAllTasks() {
        return taskdao.selectAllTasks();
    }

    public Optional<Task> selectTaskById(UUID id) {
        return taskdao.selectTaskById(id);
    }

    public int updateTaskNameById(UUID id, Task task) {
        return taskdao.updateTaskNameById(id, task);
    }

    public int updateTaskDescriptionById(UUID id, Task task) {
        return taskdao.updateTaskDescriptionById(id, task);
    }

    public int updateTaskRequieredVolunteersById(UUID id, Task task) {
        return taskdao.updateTaskRequieredVolunteersById(id, task);
    }

    public int updateTaskFinishDateById(UUID id, Task task) {
        return taskdao.updateTaskFinishDateById(id, task);
    }

    public int deleteTaskById(UUID id) {
        return taskdao.deleteTaskById(id);
    }
 
}