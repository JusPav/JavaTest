package lt.code.academy;

import java.util.Map;
import java.util.Scanner;

public class Main {
    private final Map<Integer, User> users;
    private final ReadWriteUser readWriteUser;

    public Main() {
        readWriteUser = new ReadWriteUser();
        users = readWriteUser.getUsers();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main task = new Main();

        String action;

        do {
            task.menu();
            action = sc.nextLine();
            task.userAction(action, sc);
        } while (!action.equals("3"));
    }
    private void menu() {
        System.out.println("""
                [1]. Add user
                [2]. Print users
                [3]. End program""");
    }
    private void userAction(String action, Scanner sc) {
        switch (action) {
            case "1" -> addUser(sc);
            case "2" -> print();
            case "3" -> {
                readWriteUser.saveUsers(users);
                System.out.println("Exit");
            }
            default -> System.out.println("There is no such choice");
        }
    }
    private void addUser(Scanner sc) {
        User user;
        int personalId;

        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter surname");
        String surname = sc.nextLine();

        System.out.println("Enter personal ID");
        personalId = sc.nextInt();
        user = users.get(personalId);
        if (user != null) {
            System.out.println("Person with such ID allready exist");
        } else {
            user = new User(name, surname, personalId);
            users.put(personalId, user);
        }
    }
    private void print() {
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
}