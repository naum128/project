
import jdk.jshell.Snippet;

import java.io.ObjectInputFilter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private String description;
    private LocalDate date;
    private Priority priority;
    private Status status;
    private final List<Task> list = new ArrayList<>();

    public Task(String name, String description, LocalDate date, Priority priority, Status status) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStatusAndPriority() {
        return "Status: " + status + ", Priority: " + priority;
    }
    public String getAllStatusAndPriority() {
        return "Name: " + name + ", Status: " + status + ", Priority: " + priority;
    }
    public String getInfo() {
        return "Name: " + name
                + ", Description: " + description
                + ", Date: " + date
                + ", Priority: " + priority
                + ", Status: " + status;
    }
}
