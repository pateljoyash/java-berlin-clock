package com.ubs.opsit.interviews.utility;

import static com.ubs.opsit.interviews.exceptions.ApplicationException.enforce;

import com.ubs.opsit.interviews.constants.BerlinClockConstants;
import com.ubs.opsit.interviews.constants.ErrorMessages;
import com.ubs.opsit.interviews.transferobject.ClockTo;

public final class InputValidator
{
	public static ClockTo validateAndRetrieveClockTO(final String inputTime)
	{
		enforce(null == inputTime || inputTime.isEmpty(), ErrorMessages.EMPTY);

		final String[] timeSplit = inputTime.split(BerlinClockConstants.SPLIT_WITH);
		enforce(timeSplit.length != 3, ErrorMessages.INPUT_INVALID);

		final ClockTo to = new ClockTo();
		try
		{
			to.setHours(Integer.parseInt(timeSplit[0]));
			to.setMinutes(Integer.parseInt(timeSplit[1]));
			to.setSeconds(Integer.parseInt(timeSplit[2]));

			validateRange(to);
		}
		catch (final NumberFormatException e)
		{
			enforce(true, ErrorMessages.ONLY_NUMBERS);
		}
		return to;
	}

	private static void validateRange(final ClockTo to)
	{
		enforce(to.getHours() < 0 || to.getHours() > 24, ErrorMessages.HOUR_INVALID);
		enforce(to.getMinutes() < 0 || to.getMinutes() > 59, ErrorMessages.MINUTES_INVALID);
		enforce(to.getSeconds() < 0 || to.getSeconds() > 59, ErrorMessages.SECONDS_INVALID);
	}
}
