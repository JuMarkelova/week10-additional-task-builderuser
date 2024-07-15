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
}