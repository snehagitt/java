import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    private static final ArrayList<String> tasks = new ArrayList<>();
    private static final ArrayList<Boolean> completed = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask(scanner);
                case 2 -> viewTasks();
                case 3 -> markTaskDone(scanner);
                case 4 -> deleteTask(scanner);
                case 5 -> System.out.println("Exiting the app. Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n=== To-Do List Menu ===");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Done");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        String task = scanner.nextLine();
        tasks.add(task);
        completed.add(false);
        System.out.println("Task added!");
    }

    private static void viewTasks() {
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            String status = completed.get(i) ? "[✔]" : "[ ]";
            System.out.printf("%d. %s %s%n", i + 1, status, tasks.get(i));
        }

        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
        }
    }

    private static void markTaskDone(Scanner scanner) {
        viewTasks();
        System.out.print("Enter task number to mark as done: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < tasks.size()) {
            completed.set(index, true);
            System.out.println("Task marked as done.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void deleteTask(Scanner scanner) {
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            completed.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
