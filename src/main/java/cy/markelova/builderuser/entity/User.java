package cy.markelova.builderuser.entity;

public class User {
    private Long id;
    private String login;
    private StringBuilder password;
    private int age;

    private User() {
    }

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public StringBuilder getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public static InnerBuilder newBuilder() {
        return new User().new InnerBuilder();
    }

    public class InnerBuilder {

        private InnerBuilder() {

        }

        public InnerBuilder setId(Long id) {
            User.this.id = id;
            return this;
        }

        public InnerBuilder setLogin(String login) {
            User.this.login = login;
            return this;
        }

        public InnerBuilder setPassword(StringBuilder password) {
            User.this.password = password;
            return this;
        }

        public InnerBuilder setAge(int age) {
            User.this.age = age;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}