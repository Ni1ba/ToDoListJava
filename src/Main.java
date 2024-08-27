import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "todolist.txt";
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args)
    {
        //loadTasks();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("To-Do List:");
            //displayTasks();
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //addTask();
                    break;
                case 2:
                    //removeTask();
                    break;
                case 3:
                    //saveTasks();
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

}