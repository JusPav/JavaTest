package lt.code.academy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadWriteUser {
    private static final String FILE_NAME = "users.txt";
    Map<Integer, User> getUsers() {
        Map<Integer, User> users = new HashMap<>();
        try (ObjectInput oi = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                User user = (User) oi.readObject();
                users.put(user.personalId(), user);
            }
        } catch (EOFException e) {
        } catch (Exception e) {
            System.out.println("Cannot read from file" + e.getMessage());
        }
        return users;
    }
    void saveUsers(Map<Integer, User> users) {
        try (ObjectOutput ob = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            for (User user : users.values()) {
                ob.writeObject(user);
            }
        } catch (IOException e) {
            System.out.println("Cannot write to file" + e.getMessage());
        }
    }
}
