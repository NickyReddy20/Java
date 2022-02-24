package production.business;

import java.util.regex.*;

public class UserAccount {
	
	private String userName;
	private String password;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public UserAccount() {	
	}
	
	public static String checkInputError(String userName, String password, String firstName, String lastName, String email, String phone){
		String errorMessage ="";
		if (!isUserNameValid(userName))
				errorMessage += "Invalid user name.\n";
		if (!isPasswordValid(password))
				errorMessage += "Invalid password.\n";	
		if (!isFirstNameValid(firstName))
			errorMessage += "Invalid first name.\n";
		if (!isLastNameValid(lastName))
			errorMessage += "Invalid last name.\n";
		if (!isEmailValid(email))
			errorMessage += "Invalid email.\n";
		if (!isPhoneNumberValid(phone))
			errorMessage += "Invalid phone number.\n";
		return errorMessage;
	}
	
	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	// you need to complete this method; do not change the return type
	public static boolean isUserNameValid(String userName){
		// check if userName is valid
		if(userName.length() == 0 || !Character.isLetter(userName.charAt(0)))
			return false;
		String usernameReg = "[a-zA-Z\\d]*_?[a-zA-Z\\d]+";
		Pattern pattern = Pattern.compile(usernameReg);

		Matcher m = pattern.matcher(userName);
		return m.matches();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	// you need to complete this method; do not change the return type
	public static boolean isPasswordValid(String password){
		// check if password is valid
		String passReg = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$^&])"
                       + "(?=\\S+$).{6,100}$";
        Pattern pattern = Pattern.compile(passReg);
        if (password == null) {
            return false;
        }
		
        Matcher m = pattern.matcher(password);
        return m.matches();
	}

    public boolean isValidCredential(String userName, String password) {
         return matchUserName(userName) && matchPassword(password);
    }
    
    public boolean matchUserName(String userName) {
         return userName != null && userName.equalsIgnoreCase(this.userName);
    }
    
    private boolean matchPassword(String password) {
        return password != null && password.equals(this.password);
   }

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	// you need to complete this method; do not change the return type
	public static boolean isFirstNameValid(String firstName){
		// check if firstName is valid
		if (firstName.length() == 0)
			return false;
		for (int i = 0; i < firstName.length(); i++) {
			if (!Character.isLetter(firstName.charAt(i)))
				return false;
		}
		return true;
	}
	
	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	// you need to complete this method; do not change the return type
	public static boolean isLastNameValid(String lastName){
		// check if lastName is valid
		if (lastName.length() == 0)
			return false;
		for (int i = 0; i < lastName.length(); i++) {
			if (!Character.isLetter(lastName.charAt(i)))
				return false;
		}
		return true;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	// you need to complete this method; do not change the return type
	public static boolean isEmailValid(String email){
		// check if email is valid
		String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pattern = Pattern.compile(emailReg);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
	}

	public String getPhoneNumber(){
		return phone;
	}

	public void setPhoneNumber(String phone){
		this.phone = phone;
	}

	// you need to complete this method; do not change the return type
	public static boolean isPhoneNumberValid(String phone){
		// check if phone (number) is valid
		if (phone.length() == 0)
			return false;
		if (phone.length() != 10)
			return false;
		for (int i = 0; i < phone.length(); i++) {
			if (!Character.isDigit(phone.charAt(i)))
				return false;
		}

		return true;
	}


}
