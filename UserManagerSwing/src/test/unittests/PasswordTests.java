package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class PasswordTests extends TestCase {

	public void testValidPassword() {
		assertTrue(UserAccount.isPasswordValid("@White0House"));
		assertTrue(UserAccount.isPasswordValid("WhiteHouse@123"));
		assertTrue(UserAccount.isPasswordValid("WhiteHouse123$"));
		assertTrue(UserAccount.isPasswordValid("123WhiteHouse@"));
	}

	public void testInValidPassword() {
		assertFalse(UserAccount.isPasswordValid("W@123"));
		assertFalse(UserAccount.isPasswordValid("White0House123"));
		assertFalse(UserAccount.isPasswordValid("WhiteHouse"));
		assertFalse(UserAccount.isPasswordValid("whitehouse"));
		assertFalse(UserAccount.isPasswordValid("whitehouse@"));
		assertFalse(UserAccount.isPasswordValid("whitehouse123"));
		assertFalse(UserAccount.isPasswordValid("whitehouse123@"));
		assertFalse(UserAccount.isPasswordValid("WhiteHouse@"));
	}

}
