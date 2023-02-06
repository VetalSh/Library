package library.model.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    User user;

    @Before
    public void testBuildUser() {
        user = new User.Builder().build();
    }

    @Test
    public void testDefaultUserRole() {
        Assert.assertEquals(user.getRole(), User.Role.USER);
    }

    @Test
    public void testDefaultUserState() {
        Assert.assertEquals(user.getState(), User.State.VALID);
    }

    @Test
    public void testDefaultUserID() {
        Assert.assertEquals(user.getId(), -1);
    }

    @Test
    public void testBuildCustomUserState() {
        user.setState(User.State.UNKNOWN);
        Assert.assertEquals(user.getState(), User.State.UNKNOWN);
    }

    @Test
    public void testBuildCustomUserRole() {
        user.setRole(User.Role.UNKNOWN);
        Assert.assertEquals(user.getRole(), User.Role.UNKNOWN);
    }

    @Test
    public void testBuildUserRoleOfString() {
        User user1 = new User.Builder().setRole("ADMIN").build();
        Assert.assertEquals(user1.getRole(), User.Role.ADMIN);
    }

    @Test
    public void testBuildUserRoleOfNullString() {
        String role = null;
        User user1 = new User.Builder().setRole(role).build();
        Assert.assertEquals(user1.getRole(), User.Role.USER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuilderBuildUserRoleOfStringNonARoleName() {
        String role = "kasdfk";
        User user1 = new User.Builder().setRole(role).build();
        Assert.assertEquals(user1.getRole(), User.Role.UNKNOWN);
    }
}