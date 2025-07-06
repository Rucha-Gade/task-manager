package crud;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Tasks {

    public void addTask(model.Tasks task) {
        String sql = "INSERT INTO TASKS(name, description, deadline, status, category_id, priority) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setDate(3, task.getDeadline());
            statement.setString(4, task.getStatus());
            statement.setInt(5, task.getCategoryID());
            statement.setString(6, task.getPriority());

            statement.executeUpdate();
            System.out.println("Task added.");
        } catch (SQLException e) {
            System.out.println("Error adding the tasks in the database: " + e.getMessage());
        }
    }

    public List<model.Tasks> getAllTasks() {
        List<model.Tasks> tasks = new ArrayList<>();
        String sql = "SELECT * FROM TASKS";

        try (Connection connection = DBConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                model.Tasks task = new model.Tasks(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDate("deadline"),
                        rs.getString("status"),
                        rs.getString("priority"),
                        rs.getInt("category_id")
                );
                tasks.add(task);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching tasks from the database: " + e.getMessage());
        }
        return tasks;
    }

    public void updateTasks(model.Tasks task) {
        String sql = "UPDATE TASKS SET name = ?, description = ?, deadline = ?, status = ?, priority = ?, category_id = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setDate(3, task.getDeadline());
            statement.setString(4, task.getStatus());
            statement.setString(5, task.getPriority());
            statement.setInt(6, task.getCategoryID());
            statement.setInt(7, task.getId());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Task updated.");
            } else {
                System.out.println("No task found for the given ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating the task in the database: " + e.getMessage());
        }
    }

    public void deleteTask(int id) {
        String sql = "DELETE FROM TASKS WHERE id = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Task deleted.");
            } else {
                System.out.println("No task found for the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting the task from the database: " + e.getMessage());
        }
    }

    public void markTaskCompleted(int id) {
        String sql = "UPDATE TASKS SET status = 'Completed' WHERE id = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Task marked as completed.");
            } else {
                System.out.println("No task found for the given ID.");
            }
        } catch (SQLException e) {
        }
    }
}
