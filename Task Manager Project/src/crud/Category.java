package crud;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Category {

    public void addCategory(model.Category category) {
        String sql = "INSERT INTO CATEGORY (name, parent_id) VALUES (?, ?)";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, category.getName());
            if (category.getParentId() != null) {
                statement.setInt(2, category.getParentId());
            } else {
                statement.setNull(2, java.sql.Types.INTEGER);
            }
            statement.executeUpdate();
            System.out.println("category added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding category: " + e.getMessage());
        }
    }

    public static List<model.Category> getAllCategories() {
        List<model.Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORY";
        try (Connection connection = DBConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql);) {
            while (rs.next()) {
                model.Category category = new model.Category(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("parent_id")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println("Error getting categories: " + e.getMessage());
        }

        return categories;
    }

    public void deleteCategory(int id) {
        String sql = "DELETE FROM CATEGORY WHERE id=?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Category deleted successfully.");
            } else {
                System.out.println("Category not found.");
            }
        } catch(SQLException e) {
            System.out.println("Error deleting category: " + e.getMessage());
        }
    }
}
