package cl.tbd.back.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.back.model.Task;
import cl.tbd.back.service.TaskService;

@CrossOrigin
@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(@Valid @NonNull TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/api/v1/tasks")
    public void insertTask(@RequestBody Task task) {
        taskService.insertTask(task);
    }

    @GetMapping("/api/v1/tasks")
    public List<Task> selectAllTasks() {
        return taskService.selectAllTasks();
    }

    @GetMapping("/api/v1/tasks/{id}")
    public Task selectTaskById(@PathVariable("id") UUID id) {
        return taskService.selectTaskById(id).orElse(null);
    }

    @PutMapping("/api/v1/tasks/name/{id}")
    public void updateTaskNameById(@PathVariable("id") UUID id, @Valid @NonNull Task task) {
        taskService.updateTaskNameById(id, task);
    }

    @PutMapping("/api/v1/tasks/description/{id}")
    public void updateTaskDescriptionById(@PathVariable("id") UUID id, @Valid @NonNull Task task) {
        taskService.updateTaskDescriptionById(id, task);
    }

    @PutMapping("/api/v1/tasks/required/{id}")
    public void updateTaskRequieredVolunteersById(@PathVariable("id") UUID id, @Valid @NonNull Task task) {
        taskService.updateTaskRequieredVolunteersById(id, task);
    }

    @PutMapping("/api/v1/tasks/finish/{id}")
    public void updateTaskFinishDateById(@PathVariable("id") UUID id, @Valid @NonNull Task task) {
        taskService.updateTaskFinishDateById(id, task);
    }

    @DeleteMapping("/api/v1/tasks/{id}")
    public void deleteAbilityById(@PathVariable("id") UUID id) {
        taskService.deleteTaskById(id);
    }

}