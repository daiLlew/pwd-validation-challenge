package dai.llew.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by daiLlew on 11/09/2023.
 */
public class PasswordValidationImplTest {

	private PasswordValidator passwordValidator;

	@BeforeEach
	public void setUp() {
		this.passwordValidator = new PasswordValidatorImpl();
	}

	@Test
	public void expect_false_for_null_password() {
		assertFalse(passwordValidator.isValid(null), "expected password invalid when value is null");
	}

	@Test
	public void expect_false_for_empty_password() {
		assertFalse(passwordValidator.isValid(""), "expected password invalid when value is empty");
	}

	@Test
	public void expect_false_if_does_not_contain_uppercase_char() {
		assertFalse(passwordValidator.isValid("password"), "expected password invalid when value does not contain uppercase char");
	}

	@Test
	public void expect_false_if_does_not_contain_lowercase_char() {
		assertFalse(passwordValidator.isValid("PASSWORD"), "expected password invalid when value does not contain lowercase char");
	}

	@Test
	public void expect_false_if_does_not_contain_numeric_char() {
		assertFalse(passwordValidator.isValid("PaSsWoRd"), "expected password invalid when value does not contain a numeric value");
	}

	@Test
	public void expect_false_if_does_not_contain_underscore() {
		assertFalse(passwordValidator.isValid("Passw0rd"), "expected password invalid when value does not contain an underscore");
	}

	@Test
	public void expect_false_if_password_length_is_less_than_8_chars() {
		assertFalse(passwordValidator.isValid("P1_a"), "expected password invalid when value is less than 8 chars in length");
	}

	@Test
	public void expect_true_if_contains_all_required_chars() {
		assertTrue(passwordValidator.isValid("Pa55_w0rd"), "expected password valid when value contains all required characters");
	}
}
