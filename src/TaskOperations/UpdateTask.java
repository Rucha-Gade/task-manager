
package TaskOperations;

import java.sql.Date;
import util.InputUtil;

public class UpdateTask {
    public static void updateTask() {
        ViewAllTasks.displayAllTasks();
        int taskId = InputUtil.getIntegerInput("Enter the Task ID to update the task: ");
        String name = InputUtil.getStringInput("Enter Task Name: ");
        String description = InputUtil.getStringInput("Enter Task Description: ");
        Date deadline = InputUtil.getDateInput("Enter Task Deadline (YYYY-MM-DD): ");
        String status = InputUtil.getStringInput("Enter Task Status (Not Started/ In Progress/ Completed): ");
        String priority = InputUtil.getStringInput("Enter Task Priority (High/ Medium/ Low):");
        Integer categoryId = InputUtil.getIntegerInput("Enter Category ID: ");

        model.Tasks updateTasks = new model.Tasks(taskId, name, description, deadline, status, priority, categoryId);
        crud.Tasks task = new crud.Tasks();
        task.updateTasks(updateTasks);
        ViewAllTasks.displayAllTasks();
    }


}
