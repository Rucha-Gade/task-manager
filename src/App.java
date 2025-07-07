    import CategoryOperations.AddCategory;
    import CategoryOperations.DeleteCategory;
    import CategoryOperations.ViewAllCategories;
    import TaskOperations.AddTask;
    import TaskOperations.DeleteTask;
    import TaskOperations.MarkTaskAsCompleted;
    import TaskOperations.UpdateTask;
    import TaskOperations.ViewAllTasks;
    import util.InputUtil;

    public class App {

        public static void main(String[] args) {

            boolean continueApp = true;

            do {
                System.out.println("\n =============================== ");
                System.out.println("          Task Manager         ");
                System.out.println("      Organize your Tasks       ");
                System.out.println(" =============================== ");

                System.out.println();
                System.out.println("1. Add Task");
                System.out.println("2. Delete Task");
                System.out.println("3. Update Task");
                System.out.println("4. Display All Tasks");
                System.out.println("5. Add Category");
                System.out.println("6. View Category");
                System.out.println("7. Delete Category");
                System.out.println("8. Mark Task as Completed");
                System.out.println("0. Exit");
                System.out.println("--------------------------------");
                int choice = InputUtil.getIntegerInput("Enter your choice: ");

                switch (choice) {
                    case 1 ->
                        AddTask.addTask();
                    case 2 ->
                        DeleteTask.deleteTask();
                    case 3 ->
                        UpdateTask.updateTask();
                    case 4 ->
                        ViewAllTasks.displayAllTasks();
                    case 5 ->
                        AddCategory.addCategory();
                    case 6 ->
                        ViewAllCategories.viewCategory();
                    case 7 ->
                        DeleteCategory.deleteCategory();
                    case 8 ->
                        MarkTaskAsCompleted.markTaskCompleted();
                    case 0 -> {
                        System.out.println("Exiting the application...");
                        continueApp = false;
                    }
                    default -> {
                        System.out.println("Invalid choice. Please choose a valid option.");
                    }
                }

                if (continueApp) {
                    boolean validInput = false;
                    while (!validInput) {
                        String again = InputUtil.getCharacterInput(
                                "Enter y/Y if you want to continue on the application. Enter n/N if you want to exit the application: "
                        );
                        switch (again.toLowerCase()) {
                            case "n" -> {
                                System.out.println("Exiting the application...");
                                continueApp = false;
                                validInput = true;
                            }
                            case "y" -> {
                                continueApp = true;
                                validInput = true;
                            }
                            default ->
                                System.out.println("Invalid input. Please enter 'y' or 'n' only.");
                        }
                    }
                }

            } while (continueApp);
        }

    }
