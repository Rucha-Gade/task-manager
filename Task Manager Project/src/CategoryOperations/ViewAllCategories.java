
package CategoryOperations;

import java.util.List;
import util.InputUtil;

public class ViewAllCategories {
    public static void viewCategory() {
        List<model.Category> categories = crud.Category.getAllCategories();

        if (categories.isEmpty()) {
            System.out.println("No categories available.");
            return;
        }

        // Display main categories once
        System.out.println("-------------------------------------------------");
        System.out.printf("| %-4s | %-20s | %-15s |\n", "ID", "Name", "Subcategories");
        System.out.println("-------------------------------------------------");

        for (model.Category c : categories) {
            if (c.getParentId() == null || c.getParentId() == 0) {
                boolean hasSubcategories = categories.stream()
                        .anyMatch(sub -> sub.getParentId() != null && sub.getParentId().equals(c.getId()));
                String subStatus = hasSubcategories ? "Yes" : "No";
                System.out.printf("| %-4d | %-20s | %-15s |\n",
                        c.getId(),
                        InputUtil.trimTextInput(c.getName(), 20),
                        subStatus);
            }
        }
        System.out.println("-------------------------------------------------");

        String input = InputUtil.getStringInput("Enter Category ID to view subcategories, or B to go back: ");

        if (input.equalsIgnoreCase("b")) {
            System.out.println("Returning to main menu...");
            return;
        }

        try {
            int catId = Integer.parseInt(input);

            List<model.Category> subcategories = categories.stream()
                    .filter(c -> c.getParentId() != null && c.getParentId() == catId)
                    .toList();

            if (subcategories.isEmpty()) {
                System.out.println("No subcategories found for this category.");
            } else {
                System.out.println("\nSubcategories for Category ID " + catId + ":");
                System.out.println("--------------------------------------------");
                System.out.printf("| %-4s | %-20s | %-10s |\n", "ID", "Name", "Parent ID");
                System.out.println("--------------------------------------------");
                for (model.Category sca : subcategories) {
                    System.out.printf("| %-4d | %-20s | %-10d |\n",
                            sca.getId(),
                            InputUtil.trimTextInput(sca.getName(), 20),
                            sca.getParentId());
                }
                System.out.println("--------------------------------------------");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid category ID or 'B'.");
        }

        // Return to main menu after showing subcategories without repeating main categories
        System.out.println("Returning to main menu...");
    }

}
