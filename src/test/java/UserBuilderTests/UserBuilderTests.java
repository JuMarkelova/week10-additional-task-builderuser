package UserBuilderTests;

import cy.markelova.builderuser.entity.User;
import cy.markelova.builderuser.service.Controller;
import cy.markelova.builderuser.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserBuilderTests {

    @Test
    public void testSimpleBuildUser() {
        User user = User.newBuilder()
                .setId(746L)
                .setLogin("lalala")
                .setPassword(new StringBuilder("123dfg*"))
                .setAge(19)
                .build();
        Assert.assertEquals(user.getId(), 746, "Incorrect id");
        Assert.assertEquals(user.getLogin(), "lalala", "Incorrect login");
        Assert.assertEquals(user.getPassword().toString(), "123dfg*", "Incorrect password");
        Assert.assertEquals(user.getAge(), 19, "Incorrect age");
    }

    @Test
    public void testRandomBuildUser() {
        User user = User.newBuilder()
                .setRandomId()
                .setRandomLogin()
                .setRandomPassword()
                .setRandomAge()
                .build();
        Assert.assertEquals(user.getId(), 1L, "Incorrect id");
        Assert.assertTrue(user.getLogin().length() >= 5 && user.getLogin().length() <= 20, "Incorrect login");
        Assert.assertTrue(user.getPassword().length() >= 5 && user.getPassword().length() <= 20, "Incorrect password");
        Assert.assertTrue(user.getAge() >= 0 && user.getAge() <= 99, "Incorrect age");
    }

    @Test
    public void testGenRandomId() {
        User user1 = User.newBuilder()
                .setRandomId()
                .setRandomLogin()
                .setRandomPassword()
                .setRandomAge()
                .build();
        User user2 = User.newBuilder()
                .setRandomId()
                .setRandomLogin()
                .setRandomPassword()
                .setRandomAge()
                .build();
        Assert.assertEquals(user1.getId(), 1L, "Incorrect id");
        Assert.assertEquals(user2.getId(), 2L, "Incorrect id");

    }

    @Test
    public void sortUsers() {
        User user1 = User.newBuilder()
                .setId(1)
                .setLogin("lalala")
                .setPassword(new StringBuilder("lalala"))
                .setAge(25)
                .build();
        User user2 = User.newBuilder()
                .setId(2)
                .setLogin("lalalada")
                .setPassword(new StringBuilder("lalalada"))
                .setAge(14)
                .build();
        User user3 = User.newBuilder()
                .setId(3)
                .setLogin("lalarea")
                .setPassword(new StringBuilder("lalarea"))
                .setAge(19)
                .build();
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        Assert.assertEquals(userList.get(0).getAge(), 25, "Added incorrect");
        Assert.assertEquals(userList.get(1).getAge(), 14, "Added incorrect");
        Assert.assertEquals(userList.get(2).getAge(), 19, "Added incorrect");
        userList = new Controller(new UserService()).sortUsers(userList.stream());
        Assert.assertEquals(userList.get(0).getAge(), 14, "Sorted incorrect");
        Assert.assertEquals(userList.get(1).getAge(), 19, "Sorted incorrect");
        Assert.assertEquals(userList.get(2).getAge(), 25, "Sorted incorrect");
    }
}