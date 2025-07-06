
package CategoryOperations;

import crud.Category;
import util.InputUtil;

public class DeleteCategory {
     public static void deleteCategory() {
        ViewAllCategories.viewCategory();
        int categoryId = InputUtil.getIntegerInput("Enter category ID to delete: ");
        crud.Category category = new Category();

        String confirm = InputUtil.getCharacterInput("Are you sure you want to delete category " + categoryId + ". Press y/Y to confirm. Press n/N to dismiss: ");
        switch (confirm) {
            case "y" ->
                category.deleteCategory(categoryId);
            case "n" ->
                System.out.println("Deletion of categoyr cancelled.");
            default ->
                System.out.println("Enter a valid input");
        }
        ViewAllCategories.viewCategory();
    }

}
