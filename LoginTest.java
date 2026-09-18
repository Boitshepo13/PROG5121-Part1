/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class LoginTest {
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testUsernameCorrectlyFormatted() {
        assertEquals(true, login.checkUserName("kyl_1")); // should be true
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertEquals(false, login.checkUserName("kyle!!!!!!!")); // should be false
    }

    @Test
    public void testPasswordMeetsComplexity() {
        assertEquals(true, login.checkPasswordComplexity("Ch&&sec@ke99!")); // valid password
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        assertEquals(false, login.checkPasswordComplexity("password")); // invalid
    }

    @Test
    public void testCellCorrect() {
        assertEquals(true, login.checkCellPhoneNumber("+27838968976")); // correct format
    }

    @Test
    public void testCellIncorrect() {
        assertEquals(false, login.checkCellPhoneNumber("08966553")); // no +27
    }

    @Test
    public void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals(true, login.loginUser("kyl_1", "Ch&&sec@ke99!")); // login ok
    }

    @Test
    public void testLoginFailed() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals(false, login.loginUser("wrong", "wrong")); // login fail
    }
}
}
