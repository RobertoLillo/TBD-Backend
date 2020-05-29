package cl.tbd.back.dao.das;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.back.dao.TaskDao;
import cl.tbd.back.model.Task;

@Repository("postgresTask")
public class TaskDataAccessService implements TaskDao {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertTask(UUID id, Task task) {
        String sql1 = "INSERT INTO tasks (id, id_emergency, name, description, required_volunteers, enrolled_volunteers, start_date, finish_date) ";
        String sql2 = "VALUES (:id, :id_emergency, :name, :description, :required_volunteers, :enrolled_volunteers, :start_date, :finish_date)";
        final String sql = sql1 + sql2;
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("id_emergency", task.getIdEmergency())
                .addParameter("name", task.getName())
                .addParameter("description", task.getDescription())
                .addParameter("required_volunteers", task.getRequiredVolunteers())
                .addParameter("enrolled_volunteers", task.getEnrolledVolunteers())
                .addParameter("start_date", task.getStartDate())
                .addParameter("finish_date", task.getFinishDate())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public List<Task> selectAllTasks() {
        final String sql = "SELECT * FROM tasks";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                .executeAndFetch(Task.class);
        }
    }

    @Override
    public Optional<Task> selectTaskById(UUID id) {
        String sql1 = "SELECT * FROM tasks ";
        String sql2 = "WHERE id = :searchId";
        final String sql = sql1 + sql2;
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                .addParameter("searchId", id)
                .executeAndFetch(Task.class)
                .stream()
                .findFirst();
        }
    }

    @Override
    public int updateTaskNameById(UUID id, Task task) {
        final String sql = "UPDATE tasks SET name = :name WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("name", task.getName())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public int updateTaskDescriptionById(UUID id, Task task) {
        final String sql = "UPDATE tasks SET description = :description WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("description", task.getDescription())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public int updateTaskRequieredVolunteersById(UUID id, Task task) {
        final String sql = "UPDATE tasks SET required_volunteers = :required_volunteers WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("required_volunteers", task.getRequiredVolunteers())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public int updateTaskFinishDateById(UUID id, Task task) {
        final String sql = "UPDATE tasks SET finish_date = :finish_date WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("finish_date", task.getFinishDate())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public int deleteTaskById(UUID id) {
        final String sql = "DELETE FROM tasks WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .executeUpdate();
            return 0;
        }
    }
    
}