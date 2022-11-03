package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
	public LocalDate calculateExpiryDate(PayData payData) {
		int addedMonths = payData.getPayAmount() / 10_000;
		if (payData.getFirstBillingDate() != null) {
			return expiryDateUsingFirstBillingDate(payData, addedMonths);
		} else {
			return payData.getBillingDate().plusMonths(addedMonths);
		}
	}

	public LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
		LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
		if (!iSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)) {
			final int dayLenOfCandiMon = lastDayOFMonth(candidateExp);
			final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
			if (dayLenOfCandiMon < dayOfFirstBilling) {
				return candidateExp.withDayOfMonth(dayLenOfCandiMon);
			}
			return candidateExp.withDayOfMonth(dayOfFirstBilling);
		} else {
			return candidateExp;
		}
	}

	public boolean iSameDayOfMonth(LocalDate date1, LocalDate date2) {
		return date1.getDayOfMonth() == date2.getDayOfMonth();
	}

	public int lastDayOFMonth(LocalDate date) {
		return YearMonth.from(date).lengthOfMonth();
	}
}

