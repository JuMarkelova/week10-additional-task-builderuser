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
}