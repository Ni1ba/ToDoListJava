import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "todolist.txt";
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args)
    {
        loadTasks();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("To-Do List:");
            displayTasks();
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    removeTask(scanner);
                    break;
                case 3:
                    saveTasks();
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

    }

    private static void addTask(Scanner scanner) {
        System.out.println("Введите новую задачу:");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Задача добавлена.");
    }
    private static void removeTask(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }
        System.out.println("Введите номер задачи для удаления:");
        int index = scanner.nextInt();
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("Задача удалена.");
        } else {
            System.out.println("Неверный номер задачи.");
        }
    }

    private static void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            System.out.println("Файл не найден. Создан новый список задач.");
        }
    }

    private static void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении задач.");
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}