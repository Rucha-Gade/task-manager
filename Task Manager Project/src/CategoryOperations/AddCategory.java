
package CategoryOperations;

import crud.Category;
import util.InputUtil;

public class AddCategory {
    public static void addCategory() {
        ViewAllCategories.viewCategory();
        String name = InputUtil.getStringInput("Enter Category Name: ");
        int parent_id = InputUtil.getIntegerInput("Enter 0 if it is a main category. Enter the main category ID if it is a sub-category: ");

        Integer ParentID = (parent_id == 0) ? null : parent_id;
        model.Category newCategory = new model.Category(0, name, ParentID);
        crud.Category enterCategory = new Category();
        enterCategory.addCategory(newCategory);
        ViewAllCategories.viewCategory();
    }


}
