package dai.llew.validation;

import java.util.regex.Pattern;

/**
 * Created by daiLlew on 11/09/2023.
 */
public class PasswordValidatorImpl implements PasswordValidator {

	// (?=) positive lookahead
	// (?!) negative lookahead.
	// (?=\w+\s+\w+\s+\w+\s+\w+.*)

	/**
	 * Valid passwords require:
	 * 1 or more uppercase chars
	 * 1 or more lowercase chars
	 * 1 or more digits
	 * 1 or more underscore chars.
	 * Passwords are considered valid if they meet the above criteria even if they contain other characters.
	 */
	private static final String PASSWORD_REGEX = "\\A(?=.*[A-Z]+)(?=.*[a-z]+)(?=.*[0-9]+)(?=.*_+).{8,}\\Z";
	private static final Pattern REGEX = Pattern.compile(PASSWORD_REGEX);

	@Override
	public boolean isValid(String password) {
		if (null == password) {
			return false;
		}

		return REGEX.matcher(password).matches();
	}
}
