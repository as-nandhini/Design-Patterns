import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AstronautScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Schedule schedule = new Schedule();

        while (true) {
            System.out.println("\n--- Astronaut Daily Schedule ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task Completed");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number between 1-7.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Description: ");
                        String desc = sc.nextLine();
                        System.out.print("Start time (HH:mm): ");
                        LocalTime st = LocalTime.parse(sc.nextLine());
                        System.out.print("End time (HH:mm): ");
                        LocalTime et = LocalTime.parse(sc.nextLine());
                        System.out.print("Priority (HIGH/MEDIUM/LOW): ");
                        String pri = sc.nextLine();
                        schedule.addTask(new Task(desc, st, et, pri));
                        System.out.println("Task added successfully. No conflicts.");
                        break;
                    case 2:
                        System.out.print("Description to remove: ");
                        schedule.removeTask(sc.nextLine());
                        System.out.println("Task removed.");
                        break;
                    case 3:
                        for (Task t : schedule.getAllTasks()) {
                            System.out.println(t);
                        }
                        break;
                    case 4:
                        System.out.print("Task to edit: ");
                        String target = sc.nextLine();
                        Task edit = schedule.findTask(target);
                        if (edit == null) {
                            System.out.println("Task not found.");
                            break;
                        }
                        System.out.print("New Description: ");
                        String newDesc = sc.nextLine();
                        System.out.print("New Start time (HH:mm): ");
                        LocalTime newSt = LocalTime.parse(sc.nextLine());
                        System.out.print("New End time (HH:mm): ");
                        LocalTime newEt = LocalTime.parse(sc.nextLine());
                        System.out.print("New Priority: ");
                        String newPri = sc.nextLine();
                        edit.editTask(newDesc, newSt, newEt, newPri);
                        System.out.println("Task updated.");
                        break;
                    case 5:
                        System.out.print("Description to mark completed: ");
                        Task done = schedule.findTask(sc.nextLine());
                        if (done == null) {
                            System.out.println("Task not found.");
                        } else {
                            done.markCompleted();
                            System.out.println("Task marked completed.");
                        }
                        break;
                    case 6:
                        System.out.print("Priority to view (HIGH/MEDIUM/LOW): ");
                        for (Task t : schedule.getTasksByPriority(sc.nextLine())) {
                            System.out.println(t);
                        }
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid time format. Use HH:mm (e.g. 09:30).");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
