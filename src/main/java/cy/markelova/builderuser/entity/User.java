package cy.markelova.builderuser.entity;

import cy.markelova.builderuser.util.DataGenerator;

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

    public static UserBuilder newBuilder() {
        return new User().new UserBuilder();
    }

    public class UserBuilder {

        long count = 0;

        private UserBuilder() {
        }

        public UserBuilder setRandomId() {
            User.this.id = ++count;
            return this;
        }

        public UserBuilder setId(long id) {
            User.this.id = id;
            return this;
        }

        public UserBuilder setRandomLogin() {
            User.this.login = String.valueOf(DataGenerator.generateRandomString());
            return this;
        }

        public UserBuilder setLogin(String login) {
            User.this.login = login;
            return this;
        }

        public UserBuilder setRandomPassword() {
            User.this.password = DataGenerator.generateRandomString();
            return this;
        }

        public UserBuilder setPassword(StringBuilder password) {
            User.this.password = password;
            return this;
        }

        public UserBuilder setRandomAge() {
            User.this.age = (int) (Math.random() * 81 + 18);
            return this;
        }

        public UserBuilder setAge(int age) {
            User.this.age = age;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}