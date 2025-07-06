
package model;

import java.sql.Date;

public class Tasks {
    private int id;
    private String name;
    private String description;
    private Date deadline;
    private String status;
    private String priority;
    private int category_id;

    public Tasks(int id, String name, String description, Date deadline, String status, String priority, int category_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.priority = priority;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getPriority() {
        return priority;
    }

    public int getCategoryID() {
        return category_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setCategoryID(int category_id) {
        this.category_id = category_id;
    }

}
