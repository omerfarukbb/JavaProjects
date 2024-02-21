import java.util.HashMap;
import java.util.Map;

public class RegistrationSystem {
    private final Map<String, User> credentials = new HashMap<>();

    public RegistrationSystem() {
    }

    public boolean hasUser(String username) {
        return credentials.containsKey(username);
    }

    public void addUser(String username, String password) {
        User user = new User(username, password);
        credentials.put(username, user);
    }

    public void removeUser(String username) {
        credentials.remove(username);
    }

    public User getUser(String username, String password) {
        User user = credentials.get(username);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
