package utilityClass

import org.testng.asserts.SoftAssert

import com.kms.katalon.core.annotation.Keyword

public class CustomSoftAssert {

	private static SoftAssert softAssert = new SoftAssert()
	/**
	 * Asserts that a condition is true.
	 *
	 * If the condition is false, an assertion error is collected to be reported at the end of the test.
	 *
	 * @param condition The condition to evaluate.
	 * @param message The message to include in the assertion error if the condition is false.
	 */
	@Keyword
	static void assertTrue(boolean condition, String message) {
		softAssert.assertTrue(condition, message)
	}

	/**
	 * Asserts that two strings are equal.
	 *
	 * If the strings are not equal, an assertion error is collected to be reported at the end of the test.
	 *
	 * @param actual The actual string value.
	 * @param expected The expected string value.
	 * @param message The message to include in the assertion error if the strings are not equal.
	 */
	@Keyword
	static void assertEquals(String actual, String expected, String message) {
		softAssert.assertEquals(actual, expected, message)
	}

	/**
	 * Asserts that all collected soft assertions are validated.
	 *
	 * This method should be called at the end of a test to report all collected assertion errors.
	 */
	@Keyword
	static void assertAll() {
		softAssert.assertAll()
	}
}
