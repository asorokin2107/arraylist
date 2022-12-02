import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final String ADD_EMAIL = "(AD{2}\\s)([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)";
    public static final String LIST_REGEX = "LIST";
    public static ArrayList<String> emailList = new ArrayList<>();

    public static void main(String[] args) {
        while(true) {
            System.out.println("Введите адрес электронной почты: \nИспользуйте команды ADD *e-mail*, LIST - вызов списка e-mail адресов.");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.matches(ADD_EMAIL)) {
                addmailTodo(input);

            } else if(input.matches(LIST_REGEX)) {
                listmailTodo();
            } else {
                System.out.println("Ошибка, неверный формат ввода, повторите попытку.");
                System.out.println("Формат - mail@mail.mail");
            }
        }

    }

    private static void listmailTodo() {
        if (emailList.size() > 0) {
            for (int i = 0; i < emailList.size(); i++) {
                System.out.println(emailList.get(i));
            }
        } else {
            System.out.println("В базе нет email-адрессов.");
        }
    }

    private static void addmailTodo(String input) {
        input = input.replaceAll(ADD_EMAIL, "$2");
        emailList.add(input);
        System.out.println("Электронная почта " + input + " добавлена в список.");
    }

}
