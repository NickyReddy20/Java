package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class UserNameTests extends TestCase {

	public void testValidUserName() {
		assertTrue(UserAccount.isUserNameValid("admin"));
		assertTrue(UserAccount.isUserNameValid("Admin"));
		assertTrue(UserAccount.isUserNameValid("admin123"));
		assertTrue(UserAccount.isUserNameValid("JOHN"));
	}

	public void testInValidUserName() {
		assertFalse(UserAccount.isUserNameValid(""));
		assertFalse(UserAccount.isUserNameValid("123Admin"));
		assertFalse(UserAccount.isUserNameValid("admin$"));
		assertFalse(UserAccount.isUserNameValid("1234"));
		assertFalse(UserAccount.isUserNameValid("%&@*$"));
	}

}
