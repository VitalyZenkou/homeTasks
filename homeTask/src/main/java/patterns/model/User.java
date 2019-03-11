package patterns.model;

public class User implements IAction {

    private final String name;
    private final String login;
    private final String password;

    private User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Override
    public void action() {
        System.out.println("Login to application!");
    }

    public static class UserBuilder {
        private String name;
        private String login;
        private String password;

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(name, login, password);
        }
    }
}
