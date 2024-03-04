import java.util.ArrayList;
import java.util.Objects;

public class AuthenticationService implements IAuthenticationService{
    private ArrayList<User> users;

    // create new Array list and adds default user
    public AuthenticationService(ArrayList<User> users_list) {
        this.users = new ArrayList<User>();
        User user = new User("test", "test");

        users.add(user);
    }

    // signs up the user given a unique username is provided
    public User signUp(String username, String password) {

        // checks if username already in use, returns null if match found
        for (User user: this.users) {
            if (Objects.equals(user.getUsername(), username)) return null;
        }

        User user = new User(username, password);
        users.add(user);

        return user;
    }

    public User logIn(String username, String password) {

        User user_found = null;

        for (User user: this.users) {
            if (Objects.equals(user.getUsername(), username)) {
                if (Objects.equals(user.getPassword(), password)) {
                    user_found = user;
                }
                break;
            }
        }

        return user_found;
    }
}
