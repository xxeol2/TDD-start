package chap02;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {
	@Test
	void meetsAllCriteria_Then_Strong() {
		PasswordStrengthMeter meter = new PasswordStrengthMeter();
		PasswordStrength result = meter.meter("ab12!@AB");
		assertEquals(PasswordStrength.STRONG, result);
	}
}
