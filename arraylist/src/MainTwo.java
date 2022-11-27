import java.util.ArrayList;
import java.util.Scanner;

public class MainTwo {
    public static final String ADD_REGEX = "(AD{2}\\s)(\\D+.*)";
    public static final String ADD_NUMBER_REGEX = "(AD{2}\\s)(\\d+)(.*)";
    public static final String EDIT_REGEX = "(EDIT\\s)(\\d+)(.*)";
    public static final String DELETE_REGEX = "(DELETE\\s)(\\d+)";
    public static final String LIST_REGEX = "LIST";
    public static ArrayList<String> todoList = new ArrayList<>();


    public static void main(String[] args) {
        while (true) {

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.matches(ADD_REGEX)) {
                addTodo(input);

            } else if (input.matches(ADD_NUMBER_REGEX)) {
                addTodoNumber(input);

            } else if (input.matches(EDIT_REGEX)) {
                editTodo(input);

            } else if (input.matches(DELETE_REGEX)) {
                deleteTodo(input);

            } else if (input.matches(LIST_REGEX)) {
                listTodo();

            } else {
                System.out.println("Ошибка");
            }

        }

    }

    private static void listTodo() {
        if (todoList.size() > 0) {
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println(todoList.get(i));
            }
        } else {
            System.out.println("В списке нет дел.");
        }
    }

    private static void deleteTodo(String input) {
        int index = Integer.parseInt(input.replaceAll(DELETE_REGEX, "$2"));
        if (todoList.size() >= index) {
            System.out.println("Дело " + todoList.get(index) + " успешно удалено");
            todoList.remove(index);
        } else {
            System.out.println("Дела под таким номером не существует.");
        }
    }

    private static void editTodo(String input) {
        int index = Integer.parseInt(input.replaceAll(EDIT_REGEX, "$2"));
        input = input.replaceAll(EDIT_REGEX, "$3").trim();
        if (todoList.size() >= index) {
            System.out.println("Дело " + todoList.get(index) + " заменено на дело " + input);
            todoList.set(index, input);
        } else {
            System.out.println("Дела под таким номером не существует.");
        }
    }

    private static void addTodoNumber(String input) {
        int index = Integer.parseInt(input.replaceAll(ADD_NUMBER_REGEX, "$2"));
        input = input.replaceAll(ADD_NUMBER_REGEX, "$3").trim();
        if (todoList.size() >= index) {
            todoList.add(index, input);
            System.out.println("Дело " + input + " помещено на место " + index);
        } else {
            todoList.add(input);
            System.out.println("Дело под номером " + index + " добавлено в конец");
        }
    }

    private static void addTodo(String input) {
        input = input.replaceAll(ADD_REGEX, "$2");
        todoList.add(input);
        System.out.println("Дело " + input + " добавлено в список.");
    }
}