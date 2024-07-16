package cy.markelova.builderuser.service;

import cy.markelova.builderuser.entity.User;

import java.util.stream.Stream;

public class UserService {

    Stream<User> createUsers(Stream<User.UserBuilder> userBuilders) {
        return userBuilders.map(
                userBuilder -> userBuilder
                        .setRandomId()
                        .setRandomLogin()
                        .setRandomPassword()
                        .setRandomAge()
                        .build()
        );
    }
}