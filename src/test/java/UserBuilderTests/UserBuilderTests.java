package UserBuilderTests;

import cy.markelova.builderuser.entity.User;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}