package cy.markelova.builderuser.service;

import cy.markelova.builderuser.entity.User;

import java.util.List;
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

    List<User> sortUsersByAge(Stream<User> userStream) {
        return userStream.sorted((user1, user2) -> Integer.compare(user2.getAge(), user1.getAge())).toList();
    }

    Stream<User> filterUsersEvenId(Stream<User> userStream) {
        return userStream.filter(user -> user.getId() % 2 == 0);
    }

    List<User> filterByIDAge(Stream<User> userStream) {
        return userStream.filter(user -> user.getId() == user.getAge()).toList();
    }
}