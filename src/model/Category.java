package model;

public class Category {
    private int id;
    private String name;
    private Integer parentId; //Integer because the parentID can be null if it does not have any sub categories iside of it.

    public Category(int id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
