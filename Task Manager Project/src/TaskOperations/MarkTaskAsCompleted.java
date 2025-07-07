
package TaskOperations;

import crud.Tasks;
import util.InputUtil;

public class MarkTaskAsCompleted {


    public static void markTaskCompleted() {
        ViewAllTasks.displayAllTasks();
        int taskId = InputUtil.getIntegerInput("Enter the Task ID to mark as Completed: ");
        crud.Tasks task = new Tasks();
        task.markTaskCompleted(taskId);
        ViewAllTasks.displayAllTasks();

    }

}
