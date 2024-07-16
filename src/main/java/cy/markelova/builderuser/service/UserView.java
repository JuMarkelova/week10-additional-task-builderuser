package cy.markelova.builderuser.service;

import cy.markelova.builderuser.entity.User;

import java.util.stream.Stream;

public class UserView {

    public void printUserStream(Stream<User> userStream) {
        userStream.forEach(System.out::println);
    }
}