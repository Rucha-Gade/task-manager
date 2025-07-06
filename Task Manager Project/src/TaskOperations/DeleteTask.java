
package TaskOperations;

import crud.Tasks;
import util.InputUtil;

public class DeleteTask {
    public static void deleteTask() {
        ViewAllTasks.displayAllTasks();
        int taskId = InputUtil.getIntegerInput("Enter the Task ID to delete: ");
        crud.Tasks task = new Tasks();
        String confirm = InputUtil.getCharacterInput("Are you sure you want to delete task " + taskId + ". Press y/Y to confirm. Press n/N to dismiss: ");
        switch (confirm) {
            case "y" ->
                task.deleteTask(taskId);
            case "n" ->
                System.out.println("Deletion of task cancelled.");
            default ->
                System.out.println("Enter a valid input");
        }
        ViewAllTasks.displayAllTasks();
    }

}
