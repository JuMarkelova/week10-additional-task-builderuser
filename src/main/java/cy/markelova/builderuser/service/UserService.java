package cy.markelova.builderuser.service;

import cy.markelova.builderuser.entity.User;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserService {

    void createUsers(Stream<User.UserBuilder> userBuilders) {
        userBuilders.map(
                userBuilder -> userBuilder
                        .setRandomId()
                        .setRandomLogin()
                        .setRandomPassword()
                        .setRandomAge()
                        .build()
        ).collect(Collectors.toList());
    }
}