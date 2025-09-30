import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Schedule {
    private List<Task> tasks;

    public Schedule() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) throws Exception {
        for (Task t : tasks) {
            if (task.conflictsWith(t)) {
                throw new Exception("Error: Task \"" + task.getDescription() + "\" conflicts with existing task \"" + t.getDescription() + "\" (" + t.getStartTime() + " - " + t.getEndTime() + ").");
            }
        }
        tasks.add(task);
    }

    public void removeTask(String description) throws Exception {
        Task toRemove = findTask(description);
        if (toRemove != null) {
            tasks.remove(toRemove);
        } else {
            throw new Exception("Error: Task not found.");
        }
    }

    public Task findTask(String description) {
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                return t;
            }
        }
        return null;
    }

    public List<Task> getAllTasks() {
        tasks.sort(Comparator.comparing(Task::getStartTime));
        return tasks;
    }

    public List<Task> getTasksByPriority(String priority) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getPriority().equalsIgnoreCase(priority)) {
                result.add(t);
            }
        }
        return result;
    }
}
