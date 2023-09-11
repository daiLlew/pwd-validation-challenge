package dai.llew.validation;

import java.util.regex.Pattern;

/**
 * Created by daiLlew on 11/09/2023.
 */
public class PasswordValidatorImpl implements PasswordValidator {

	private static final String PASSWORD_REGEX = "\\A(?=.*[A-Z]+).{3}\\Z";
	private static final Pattern REGEX = Pattern.compile(PASSWORD_REGEX);

	@Override
	public boolean isValid(String password) {
		if (null == password) {
			return false;
		}

		return REGEX.matcher(password).matches();
	}
}