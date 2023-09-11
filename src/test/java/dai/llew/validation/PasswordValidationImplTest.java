package dai.llew.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
	public void should_return_false_for_null() {
		assertFalse(passwordValidator.isValid(null), "expected false for null password");
	}

	@Test
	public void should_return_false_for_empty() {
		assertFalse(passwordValidator.isValid(""), "expected false for empty password");
	}

	@Test
	public void should_return_true_for_valid_input() {
		assertTrue(passwordValidator.isValid("AAA"), "expected true for valid input");
	}

}
