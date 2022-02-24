package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class FirstNameTests extends TestCase {
	public void testValidFirstName() {
		assertTrue(UserAccount.isLastNameValid("john"));
		assertTrue(UserAccount.isLastNameValid("John"));
	}

	public void testInValidFirstName() {
		assertFalse(UserAccount.isLastNameValid("123john"));
		assertFalse(UserAccount.isLastNameValid("123_john"));
		assertFalse(UserAccount.isLastNameValid("john123"));
		assertFalse(UserAccount.isLastNameValid("12345"));
		assertFalse(UserAccount.isLastNameValid("$*$*%&#"));
	}
}
