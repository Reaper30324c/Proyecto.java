import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Tarea agregada: " + description);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Tarea eliminada");
        } else {
            System.out.println("Índice inválido");
        }
    }

    public void markAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setStatus(Task.Status.COMPLETED);
            System.out.println("Tarea marcada como completada");
        } else {
            System.out.println("Índice inválido");
        }
    }

    public void markAsInProgress(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setStatus(Task.Status.IN_PROGRESS);
            System.out.println("Tarea marcada como en proceso");
        } else {
            System.out.println("Índice inválido");
        }
    }

    public void markAsFinalized(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setStatus(Task.Status.FINALIZED);
            System.out.println("Tarea marcada como finalizada");
        } else {
            System.out.println("Índice inválido");
        }
    }

    public void printTasks() {
        System.out.println("Tareas:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getDescription() + " - " + task.getStatus());
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Opciones:");
                System.out.println("1. Agregar tarea");
                System.out.println("2. Eliminar tarea");
                System.out.println("3. Marcar como completada");
                System.out.println("4. Marcar como en proceso");
                System.out.println("5. Marcar como finalizada");
                System.out.println("6. Mostrar tareas");
                System.out.println("7. Salir");

                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Ingrese la descripción de la tarea:");
                        String description = scanner.next();
                        toDoList.addTask(description);
                        break;
                    case 2:
                        System.out.println("Ingrese el índice de la tarea a eliminar:");
                        int index = scanner.nextInt();
                        toDoList.removeTask(index - 1);
                        break;
                    case 3:
                        System.out.println("Ingrese el índice de la tarea a marcar como completada:");
                        index = scanner.nextInt();
                        toDoList.markAsCompleted(index - 1);
                        break;
                    case 4:
                        System.out.println("Ingrese el índice de la tarea a marcar como en proceso:");
                        index = scanner.nextInt();
                        toDoList.markAsInProgress(index - 1);
                        break;
                    case 5:
                        System.out.println("Ingrese el índice de la tarea a marcar como finalizada:");
                        index = scanner.nextInt();
                        toDoList.markAsFinalized(index - 1);
                        break;
                    case 6:
                        toDoList.printTasks();
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción inválida");
                }
            }
        }
    }
}

class Task {
    private String description;
    private Status status;

    public Task(String description) {
        this.description = description;
        this.status = Status.TODO;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {     
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        TODO, IN_PROGRESS, COMPLETED, FINALIZED
    }
}