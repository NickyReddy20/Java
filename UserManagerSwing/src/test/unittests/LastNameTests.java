package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class LastNameTests extends TestCase {

	public void testValidLastName() {
		assertTrue(UserAccount.isLastNameValid("smith"));
		assertTrue(UserAccount.isLastNameValid("Smith"));
	}

	public void testInValidLastName() {
		assertFalse(UserAccount.isLastNameValid("123smith"));
		assertFalse(UserAccount.isLastNameValid("_smith"));
		assertFalse(UserAccount.isLastNameValid("smith123"));
		assertFalse(UserAccount.isLastNameValid("smithh$"));
	}

}
