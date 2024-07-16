package cy.markelova.builderuser.service;

import cy.markelova.builderuser.entity.User;

import java.util.List;
import java.util.stream.Stream;

public class Controller {
    UserService userService;
    UserView userView;

    public Controller(UserService service) {
        this.userService = service;
    }

    public Controller(UserService service, UserView view) {
        this.userService = service;
        this.userView = view;
    }

    public Stream<User> createUsers(Stream<User.UserBuilder> userBuilders) {
        return userService.createUsers(userBuilders);
    }

    public List<User> sortUsersByAge(Stream<User> userStream) {
        return userService.sortUsersByAge(userStream);
    }

    public void printUserList(List<User> userList) {
        userView.printUserList(userList);
    }

    public void printUserStream(Stream<User> userStream) {
        userView.printUserStream(userStream);
    }

    public void printUserStreamOrException(Stream<User> userStream) {
        userView.printUserStreamOrException(userStream);
    }

    public Stream<User> filterUsersEvenId(Stream<User> userStream) {
        return userService.filterUsersEvenId(userStream);
    }

    public List<User> filterByIDAge(Stream<User> userStream) {
        return userService.filterByIDAge(userStream);
    }
}