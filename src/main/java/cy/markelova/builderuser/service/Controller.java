package cy.markelova.builderuser.service;

import cy.markelova.builderuser.entity.User;

import java.util.stream.Stream;

public class Controller {
    UserService userService;

    public Controller(UserService service) {
        this.userService = service;
    }

    public void createUsers(Stream<User.UserBuilder> userBuilders) {
        userService.createUsers(userBuilders);
    }
}