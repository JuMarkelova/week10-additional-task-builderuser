package cy.markelova.builderuser._main;

import cy.markelova.builderuser.entity.User;
import cy.markelova.builderuser.service.Controller;
import cy.markelova.builderuser.service.UserService;
import cy.markelova.builderuser.service.UserView;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _Main {

    public static void main(String[] args) {
        UserService userService = new UserService();
        UserView userView = new UserView();
        Controller controller = new Controller(userService, userView);
        List<User.UserBuilder> userBuilders = IntStream
                .rangeClosed(1, 20)
                .mapToObj(_ -> User.newBuilder())
                .toList();

        System.out.println("Unsorted list:");
        List<User> userList = controller.createUsers(userBuilders.stream()).toList();
        controller.printUserList(userList);
        System.out.println("\nSorted list by age:");
        List<User> sortedUserList = controller.sortUsersByAge(userList.stream());
        controller.printUserList(sortedUserList);
        System.out.println("\nFiltered by even id list:");
        Stream<User> filteredUsers = controller.filterUsersEvenId(sortedUserList.stream());
        controller.printUserStream(filteredUsers);
        System.out.println("\nFiltered by equality of id and age list:");
        List<User> filteredByIdAgeList = controller.filterByIDAge(filteredUsers);
        controller.printUserStreamOrException(filteredByIdAgeList.stream());
    }
}