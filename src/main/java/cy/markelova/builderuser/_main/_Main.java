package cy.markelova.builderuser._main;

import cy.markelova.builderuser.service.Controller;
import cy.markelova.builderuser.entity.User;
import cy.markelova.builderuser.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _Main {

    public static void main(String[] args) {
        UserService userService = new UserService();
        Controller controller = new Controller(userService);
        List<User.UserBuilder> userBuilders = new ArrayList<>();

//        Stream<User.UserBuilder> userBuildersStream;

        for (int i = 0; i < 20; i++) {
            userBuilders.add(User.newBuilder());
        }
//
//        IntStream.rangeClosed(1, 20)
//                .forEach(_ -> userBuilders.add(User.newBuilder()));

//        controller.createUsers(userBuilders);
    }
}