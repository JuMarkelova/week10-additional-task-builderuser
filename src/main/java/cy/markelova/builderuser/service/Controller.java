package cy.markelova.builderuser.service;

import cy.markelova.builderuser.entity.User;

import java.util.stream.Stream;

public class Controller {
    UserService userService;

    public Controller(UserService service) {
        this.userService = service;
    }

    public Stream<User> createUsers(Stream<User.UserBuilder> userBuilders) {
        return userService.createUsers(userBuilders);
    }

    public Stream<User> sortUsers(Stream<User> usersStream) {
        return userService.sortUsers(usersStream);
    }
}