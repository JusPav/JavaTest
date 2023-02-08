package lt.code.academy;

import java.io.Serializable;

public record User(String name, String surname, int personalId) implements Serializable {
}
