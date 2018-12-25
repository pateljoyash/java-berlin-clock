package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.constants.BerlinClockConstants;
import com.ubs.opsit.interviews.enums.ClockProperties;
import com.ubs.opsit.interviews.transferobject.ClockTo;
import com.ubs.opsit.interviews.utility.InputValidator;;

/**
 * This is a Converter
 */
public final class BerlinClockConverter implements TimeConverter
{

	public String convertTime(final String inputTime)
	{
		final StringBuffer output = new StringBuffer();

		final ClockTo clock = InputValidator.validateAndRetrieveClockTO(inputTime);
		
		setFirstLine(output, clock.getSeconds());
		setSecondThirdLine(output, clock.getHours());
		setFourthFifthLine(output, clock.getMinutes());
		
		return output.toString();
	}

	private void setFourthFifthLine(final StringBuffer output, final Integer minutes)
	{
		int noOfMinutes = minutes / 5;
		output.append(retrievePattern(ClockProperties.YELLOW.getValue(), noOfMinutes, NO_OF_LIGHTS_FOURTH_ROW)
				.replaceAll(BerlinClockConstants.YYY, BerlinClockConstants.YYR));
		output.append(BerlinClockConstants.NEW_LINE);

		noOfMinutes = minutes - (noOfMinutes * 5);

		output.append(retrievePattern(ClockProperties.YELLOW.getValue(), noOfMinutes, NO_OF_LIGHTS_FIFTH_ROW));
	}

	private void setSecondThirdLine(final StringBuffer output, final Integer hours)
	{
		int noOfHours = hours / 5;
		output.append(retrievePattern(ClockProperties.RED.getValue(), noOfHours, NO_OF_LIGHTS_SECOND_ROW));
		output.append(BerlinClockConstants.NEW_LINE);

		noOfHours = hours - (noOfHours * 5);
		output.append(retrievePattern(ClockProperties.RED.getValue(), noOfHours, NO_OF_LIGHTS_THIRD_ROW));
		output.append(BerlinClockConstants.NEW_LINE);
	}

	private void setFirstLine(final StringBuffer output, final Integer seconds)
	{
		final Character returnChar = seconds % 2 == 0 ? ClockProperties.YELLOW.getValue()
				: ClockProperties.OFF.getValue();

		output.append(returnChar).append(BerlinClockConstants.NEW_LINE);
	}

	private static String retrievePattern(final Character symbol, final Integer noOfOnLights,
			final Integer totalNoOfLights)
	{
		final StringBuffer sBuffer = new StringBuffer();

		for (int i = 1; i <= totalNoOfLights; i++)
		{
			if (i <= noOfOnLights)
			{
				sBuffer.append(symbol);
			}
			else
			{
				sBuffer.append(ClockProperties.OFF.getValue());
			}
		}
		return sBuffer.toString();
	}

}
