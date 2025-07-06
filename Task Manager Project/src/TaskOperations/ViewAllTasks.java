
package TaskOperations;

import java.util.List;
import util.InputUtil;

public class ViewAllTasks {
    public static void displayAllTasks() {
        crud.Tasks taskCrud = new crud.Tasks();
        List<model.Tasks> tasks = taskCrud.getAllTasks();
        List<model.Category> categories = crud.Category.getAllCategories();

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-18s | %-30s | %-10s | %-12s | %-8s | %-20s | %-8s | %-20s |\n",
                "ID", "Name", "Description", "Deadline", "Status", "Priority", "Category", "MainID", "Main Category");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (model.Tasks t : tasks) {
            model.Category category = categories.stream()
                    .filter(cat -> cat.getId() == t.getCategoryID())
                    .findFirst()
                    .orElse(null);

            String categoryName = (category != null) ? category.getName() : "Unknown";
            String mainCategoryName = "-";
            String mainCategoryIdStr = "-";

            if (category != null && category.getParentId() != null && category.getParentId() != 0) {
                model.Category parentCategory = categories.stream()
                        .filter(cat -> cat.getId() == category.getParentId())
                        .findFirst()
                        .orElse(null);
                if (parentCategory != null) {
                    mainCategoryName = parentCategory.getName();
                    mainCategoryIdStr = String.valueOf(parentCategory.getId());
                } else {
                    mainCategoryName = "Unknown";
                    mainCategoryIdStr = "Unknown";
                }
            } else if (category != null) {
                mainCategoryName = category.getName();
                mainCategoryIdStr = String.valueOf(category.getId());
            }

            System.out.printf("| %-4d | %-18s | %-30s | %-10s | %-12s | %-8s | %-20s | %-8s | %-20s |\n",
                    t.getId(),
                    InputUtil.trimTextInput(t.getName(), 18),
                    InputUtil.trimTextInput(t.getDescription(), 30),
                    t.getDeadline(),
                    t.getStatus(),
                    t.getPriority(),
                    InputUtil.trimTextInput(categoryName, 20),
                    mainCategoryIdStr,
                    InputUtil.trimTextInput(mainCategoryName, 20));
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }


}
