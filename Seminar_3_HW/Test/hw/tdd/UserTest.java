package hw.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {


    @Test
    void testUserIsAuthenticate() {
        User user = new User("Mayya", "111", false);
        assertTrue(user.authenticate("Mayya", "111"));
    }

    @Test
    void testUserIsNotAuthenticateBecauseWrongName() {
        User user = new User("Mayya", "111", false);
        assertFalse(user.authenticate("Mayya1", "111"));
    }

    @Test
    void testUserIsNotAuthenticateBecauseWrongPassword() {
        User user = new User("Mayya", "111", false);
        assertFalse(user.authenticate("Mayya", "2507"));
    }

    @Test
    void userRepositoryNATest() {
        UserRepository userRepository = new UserRepository();
        User user1 = new User("user1", "111", false);
        userRepository.addUser(user1);
        assertFalse(userRepository.findByName(user1.name));
    }

    @Test
    void userRepositoryWrongPasswordTest() {
        UserRepository userRepository = new UserRepository();
        User user1 = new User("user1", "111", false);
        user1.authenticate("user1", "11");
        userRepository.addUser(user1);
        assertFalse(userRepository.findByName(user1.name));
    }

    @Test
    void userRepositoryTest() {
        UserRepository userRepository = new UserRepository();
        User user1 = new User("user1", "111", false);
        user1.authenticate("user1", "111");
        userRepository.addUser(user1);
        assertTrue(userRepository.findByName(user1.name));
    }

    @Test
    void adminNotLogOut() {

        User userAdmin = new User("user_admin", "aaa", true);
        UserRepository userRepository = new UserRepository();

        User userNotAdmin1 = new User("user0", "000", false);
        User userNotAdmin2 = new User("user1", "111", false);

        userAdmin.authenticate("user_admin","aaa");
        userNotAdmin1.authenticate("user0", "000");
        userNotAdmin2.authenticate("user1", "111");

        userRepository.addUser(userAdmin);
        userRepository.addUser(userNotAdmin1);
        userRepository.addUser(userNotAdmin2);

        userRepository.logOutAll();

        assertFalse(userNotAdmin1.isAuthenticate);
        assertTrue(userAdmin.isAuthenticate);
    }
}