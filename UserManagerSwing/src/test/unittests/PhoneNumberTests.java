package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class PhoneNumberTests extends TestCase {

	public void testValidPhoneNumber() {
		assertTrue(UserAccount.isPhoneNumberValid("8162356218"));
		assertTrue(UserAccount.isPhoneNumberValid("9849540454"));
		assertTrue(UserAccount.isPhoneNumberValid("8165165468"));
	}

	public void testInValidPhoneNumber() {
		assertFalse(UserAccount.isPhoneNumberValid("816-2356218"));
		assertFalse(UserAccount.isPhoneNumberValid("816"));
		assertFalse(UserAccount.isPhoneNumberValid("8165454654A"));
		assertFalse(UserAccount.isPhoneNumberValid("8165454654$"));
		assertFalse(UserAccount.isPhoneNumberValid("816-5454-654"));
		assertFalse(UserAccount.isPhoneNumberValid("816654"));
	}
}
