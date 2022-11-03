package chap02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {
	@Test
	void meetsAllCriteria_Then_Strong() {
		PasswordStrengthMeter meter = new PasswordStrengthMeter();
		PasswordStrength result = meter.meter("ab12!@AB");
		assertEquals(PasswordStrength.STRONG, result);
		PasswordStrength result2 = meter.meter("abc!Add");
		assertEquals(PasswordStrength.STRONG, result2);
	}

	@Test
	void meetsOtherCriteria_except_for_Length_Then_Normal() {
		PasswordStrengthMeter meter = new PasswordStrengthMeter();
		PasswordStrength result = meter.meter("ab12!@A");
		assertEquals(PasswordStrength.NORMAL, result);
		PasswordStrength result2 = meter.meter("Ab12!c");
		assertEquals(PasswordStrength.NORMAL, result2);
	}
}
