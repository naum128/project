
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainTask {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        Task newTask;
        List<?> list = null;

        String name = null;
        String description = null;
        LocalDate date = null;
        Priority priority = null;
        Status status = null;

        int index = 0;

        int choice;

        do {
            System.out.println("========== Список задач ==========");
            System.out.println("1. Создать задачу");
            System.out.println("2. Просмотреть задачу");
            System.out.println("3. Просмотреть все задачи");
            System.out.println("4. Обновить задачу");
            System.out.println("5. Удалить задачу");
            System.out.println("6. Обновить статус задачи");
            System.out.println("7. Просмотр задач по статусу и приоритету");
            System.out.println("8. Просмотр статуса всех задач");
            System.out.println("9. Сортировка задач по дате или приоритету");
            System.out.println("10. Сортировка задач по времени");
            System.out.println("11. Выход\n");
            System.out.print("Выберите действие:\n");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Введите название задачи: ");
                        name = input.next();

                        System.out.print("Введите описание: ");
                        description = input.next();

                        try {
                            System.out.println("Введите дату задачи (год/месяц/день): ");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            date = LocalDate.of(input.nextInt(), input.nextInt(), + input.nextInt());
                            String localDate = date.format(formatter);
                            System.out.println(localDate);
                        } catch (InputMismatchException e) {
                            System.out.println("Введедите числа\n");
                            break;
                        }

                        try {
                            System.out.print("Введите приоритет (h - high, m - medium, l - low): ");
                            priority = Priority.valueOf(input.next());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Введено нерпавельно\n");
                            break;
                        }

                        try {
                            System.out.println("Введите статус задачи (c - выполнено, p - в процессе, d - отложено): ");
                            status = Status.valueOf(input.next());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Введено нерпавельно\n");
                            break;
                        }

                        newTask = new Task(name, description, date, priority, status);
                        taskManager.addTusk(newTask);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Введите индекс задачи: ");
                        index = input.nextInt();
                        taskManager.readTask(index);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Все задачи: ");
                        taskManager.readAllTask();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case 4:
                    try {
                        System.out.println("Введите индекс задачи: ");
                        index = input.nextInt();

                        System.out.print("Введите новое название задачи: ");
                        name = input.next();

                        System.out.print("Введите новое описание: ");
                        description = input.next();

                        try {
                            System.out.println("Введите новую дату задачи (год/месяц/день): ");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            date = LocalDate.of(input.nextInt(), input.nextInt(), + input.nextInt());
                            String localDate = date.format(formatter);
                            System.out.println(localDate);
                        } catch (InputMismatchException e) {
                            System.out.println("Введедите числа");
                            break;
                        }

                        try {
                            System.out.print("Введите новый приоритет: ");
                            priority = Priority.valueOf(input.next());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Введено нерпавельно\n");
                            break;
                        }

                        try {
                            System.out.println("Введите новый статус задачи (c - выполнено, p - в процессе, d - отложено): ");
                            status = Status.valueOf(input.next());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Введено нерпавельно\n");
                            break;
                        }

                        Task updateTask = new Task(name, description, date, priority, status);
                        taskManager.updateTask(index , updateTask);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Введите индекс задачи: ");
                        index = input.nextInt();
                        taskManager.deleteTask(index);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 6:
                    try {
                        System.out.print("Введите индекс задачи для обновления статуса: ");
                        index = input.nextInt();

                        if (status != null) {
                            System.out.println("Статус задачи на данный момент " + status.getStatus());
                        } else {
                            System.out.println("Статус отсутствует");
                        }

                        try {
                            System.out.println("Введите новый статус задачи (c - выполнено, p - в процессе, d - отложено): ");
                            status = Status.valueOf(input.next());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Введено нерпавельно\n");
                            break;
                        }

                        Task updateTask = new Task(name, description, date, priority, status);
                        taskManager.updateStatusTask(index, updateTask);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 7:
                    try {
                        System.out.print("Введите индекс для поиска статуса и приоритета: ");
                        index = input.nextInt();
                        taskManager.readStatusAndPriorityTask(index);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 8:
                    try {
                        System.out.println("Просмотр статуса и приоритета всех задач: ");
                        taskManager.readAllStatusTask();
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 9:
                    try {
                        do {
                            System.out.println("1. Сортировка задач по дате\n");
                            System.out.println("2. Сортировка задач по приоритету\n ");
                            System.out.println("3. Выход\n");
                            choice = input.nextInt();

                            switch (choice) {
                                case 1:
                                    try {
                                        System.out.println("Сортировка задач по дате:\n");
                                        taskManager.sortByDate();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        break;
                                    }
                                    break;
                                case 2:
                                    try {
                                        System.out.println("Сортировка задач по приоритету:\n");
                                        taskManager.sortByPriority();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        break;
                                    }
                                    break;
                                default:
                                    System.out.println("Не верное действие");
                            }
                        } while (choice != 3);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                case 10:
//                    try {
//
//                    }
                case 11:
                    try {
                        System.out.println("Выход с программы");
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                default:
                    System.out.println("Не верное действие");
            }
        } while (choice != 11);
    }
}
