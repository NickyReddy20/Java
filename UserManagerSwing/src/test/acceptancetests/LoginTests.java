package test.acceptancetests;

import junit.framework.TestCase;
import production.business.UserAccount;
import production.business.UserAccountManager;

public class LoginTests extends TestCase{
    private UserAccountManager userAccountManager;

    protected void setUp() throws Exception {
        super.setUp();
        userAccountManager = new UserAccountManager();
        userAccountManager.registerNewUser("admin", "@umkcFH560B", "@umkcFH560B", "Scrum", "Master", "admin@umkc.edu",
                "9132835734");
        String result = userAccountManager.registerNewUser("johnsmith", "Hello@123", "Hello@123", "John", "Smith", "johnsmith@gmail.com", "9849540454");
        assertEquals(result, UserAccountManager.NOINPUTERROR);
    }

    public void testSuccessfulLogin() {
        UserAccount user = userAccountManager.login("johnsmith", "Hello@123");
        assertNotNull(user);
        assertTrue(user.getEmail().equalsIgnoreCase("johnsmith@gmail.com"));
    }

    public void testPasswordIncorrectLogin() {
        // password is incorrect
        UserAccount user = userAccountManager.login("johnsmith", "Hello123");
        assertNull(user);
    }

    public void testUsernameIncorrectLogin() {
        // username is incorrect
        UserAccount user = userAccountManager.login("JohnSmith123", "Hello@123");
        assertNull(user);
    }

    public void testUsernameAndPasswordIncorrectLogin() {
        // both username and password are incorrect
        UserAccount user = userAccountManager.login("johnsmiths", "Hello123@");
        assertNull(user);
    }
}
