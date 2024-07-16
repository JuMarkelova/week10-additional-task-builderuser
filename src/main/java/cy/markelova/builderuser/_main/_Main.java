package cy.markelova.builderuser._main;

import cy.markelova.builderuser.service.Controller;
import cy.markelova.builderuser.entity.User;
import cy.markelova.builderuser.service.UserService;
import cy.markelova.builderuser.service.UserView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class _Main {

    public static void main(String[] args) {
        UserService userService = new UserService();
        UserView userView = new UserView();
        Controller controller = new Controller(userService, userView);
        List<User.UserBuilder> userBuilders = new ArrayList<>();

        IntStream.rangeClosed(1, 20)
                .forEach(_ -> userBuilders.add(User.newBuilder()));

        List<User> userList = controller.createUsers(userBuilders.stream()).toList();
        System.out.println("Unsorted list:");
        controller.printUserStream(userList.stream());
        System.out.println("\nSorted list by age:");
        List<User> sortedUserList = controller.sortUsersByAge(userList.stream());
        controller.printUserStream(sortedUserList.stream());
        System.out.println("\nFiltered by even id list:");
        List<User> filteredUsers = controller.filterUsersEvenId(sortedUserList.stream());
        controller.printUserStream(filteredUsers.stream());
        System.out.println("\nFiltered by equality of id and age list:");
        List<User> filteredByIdAgeList = controller.filterByIDAge(filteredUsers.stream());
        controller.printUserStream(filteredByIdAgeList.stream());
    }
}