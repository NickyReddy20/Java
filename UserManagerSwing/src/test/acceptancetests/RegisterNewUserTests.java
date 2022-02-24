package test.acceptancetests;

import junit.framework.TestCase;
import production.business.UserAccount;
import production.business.UserAccountManager;

public class RegisterNewUserTests extends TestCase{
    private UserAccountManager userAccountManager;
	protected void setUp() throws Exception {
        super.setUp();
        userAccountManager = new UserAccountManager();
    }


    public void testSuccessfulRegistration() {
        String result = userAccountManager.registerNewUser("johnsmith", "Hello@123", "Hello@123", "John", "Smith", "johnsmith@gmail.com", "9849540454");
        System.out.println(result);
        assertEquals(result, UserAccountManager.NOINPUTERROR);

        UserAccount user = userAccountManager.login("johnsmith", "Hello@123");
        assertNotNull(user);
    }

    public void testInvalidUsernameRegistration() {
        String result = userAccountManager.registerNewUser("2021", "Hello@123", "Hello@123", "John", "Smith", "johnsmith@gmail.com", "9849540454");
        assertEquals(result, "Invalid user name.\n");

        UserAccount user = userAccountManager.login("johnsmith", "hello@123");
        assertNull(user);
    }

    public void testInvalidPasswordRegistration() {
        String result = userAccountManager.registerNewUser("johnsmith", "hello@123", "hello@123", "John", "Smith", "johnsmith@gmail.com", "9849540454");
        assertEquals(result, "Invalid password.\n");

        UserAccount user = userAccountManager.login("johnsmith", "hello@123");
        assertNull(user);
    }

    public void testPasswordMismatchRegistration() {
        String result = userAccountManager.registerNewUser("johnsmith", "Hello@123", "Hello@1234", "John", "Smith", "johnsmith@gmail.com", "9849540454");
        assertEquals(result, "Re-entered password does not match!");

        UserAccount user = userAccountManager.login("johnsmith", "Hello@123");
        assertNull(user);
    }

    public void testSameUserRegistration() {
        String result = userAccountManager.registerNewUser("johnsmith", "Hello@123", "Hello@123", "John", "Smith", "johnsmith@gmail.com", "9849540454");
        assertEquals(result, UserAccountManager.NOINPUTERROR);

        String result2 = userAccountManager.registerNewUser("johnsmith", "Hello@123", "Hello@123", "John", "Smith", "johnsmith@gmail.com", "9849540454");
        assertEquals(result2, "User name is not available!");
    }

}
