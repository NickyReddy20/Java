package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class EmailAddressTests extends TestCase {

	public void testValidEmailAddress() {
		assertTrue(UserAccount.isEmailValid("don.smith@gmail.com"));
		assertTrue(UserAccount.isEmailValid("hello@gmail.com"));
		assertTrue(UserAccount.isEmailValid("hello.me.hi@gmail.com"));
	}

	public void testInvalidEmailAddress() {
		assertFalse(UserAccount.isEmailValid("someone.com"));
		assertFalse(UserAccount.isEmailValid("someone@com"));
		assertFalse(UserAccount.isEmailValid("someonecom"));
	}
}
