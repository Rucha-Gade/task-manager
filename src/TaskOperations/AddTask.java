
package TaskOperations;

import CategoryOperations.ViewAllCategories;
import crud.Tasks;
import java.sql.Date;
import java.util.List;
import util.InputUtil;

public class AddTask {
    public static void addTask() {
        List<model.Category> categories = crud.Category.getAllCategories();

        if (categories.isEmpty()) {
            System.out.println("No categories found. Creating a main category first.");
            String name = InputUtil.getStringInput("Enter Main Category Name: ");
            model.Category newCategory = new model.Category(0, name, null);
            crud.Category addCategory = new crud.Category();
            addCategory.addCategory(newCategory);
        }

        // Display current tasks for user reference
        ViewAllTasks.displayAllTasks();

        // Ask user for action
        System.out.println("Do you want to: ");
        System.out.print(" 1. Add task in existing categories");
        System.out.print(" 2. Create a new main category");
        System.out.print(" 3. Create a new subcategory under an existing category");

        int choice = InputUtil.getIntegerInput("Enter your choice (1/2/3): ");

        switch (choice) {
            case 2 -> {
                String name = InputUtil.getStringInput("Enter Main Category Name: ");
                model.Category newCategory = new model.Category(0, name, null);
                crud.Category addCategory = new crud.Category();
                addCategory.addCategory(newCategory);
                System.out.println("Main category created successfully.");
            }
            case 3 -> {
                String name = InputUtil.getStringInput("Enter Subcategory Name: ");
                int parentId = InputUtil.getIntegerInput("Enter the Parent Category ID for this subcategory: ");
                model.Category newCategory = new model.Category(0, name, parentId);
                crud.Category addCategory = new crud.Category();
                addCategory.addCategory(newCategory);
                System.out.println("Subcategory created successfully.");
            }
            case 1 -> {

            }
            default -> {
                System.out.println("Invalid choice. Proceeding with existing categories.");
            }
        }

        ViewAllCategories.viewCategory();

        String name = InputUtil.getStringInput("Enter Task Name: ");
        String description = InputUtil.getStringInput("Enter Task Description: ");
        Date deadline = InputUtil.getDateInput("Enter Task Deadline (YYYY-MM-DD): ");
        String status = InputUtil.getStringInput("Enter Task Status (Not Started/ In Progress/ Completed): ");
        String priority = InputUtil.getStringInput("Enter Task Priority (High/ Medium/ Low): ");
        Integer categoryId = InputUtil.getIntegerInput("Enter Category ID to add this task under: ");

        model.Tasks newTask = new model.Tasks(0, name, description, deadline, status, priority, categoryId);
        crud.Tasks enterTask = new crud.Tasks();
        enterTask.addTask(newTask);
        System.out.println("Task added successfully!");

        ViewAllTasks.displayAllTasks(); // show updated task list after adding
    }

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
