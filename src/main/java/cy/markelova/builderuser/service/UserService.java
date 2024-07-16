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
         return userStream.sorted((user1, user2) -> Integer.compare(user1.getAge(), user2.getAge())).toList();
    }

    List<User> filterUsersEvenId(Stream<User> userStream) {
        return userStream.filter(user -> user.getId() % 2 == 0).toList();
    }
}