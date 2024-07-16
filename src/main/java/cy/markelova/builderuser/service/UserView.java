package cy.markelova.builderuser.service;

import cy.markelova.builderuser.entity.User;

import java.util.List;
import java.util.stream.Stream;

public class UserView {

    public void printUserList(List<User> userList) {
        userList.forEach(System.out::println);
    }

    public void printUserStream(Stream<User> userStream) {
        userStream.forEach(System.out::println);
    }

    public void printUserStreamOrException(Stream<User> userStream) {
        if (userStream.findAny().isEmpty()) {
            throw new RuntimeException("There is no users");
        } else {
            userStream.forEach(System.out::println);
        }
    }
}