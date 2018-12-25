package com.ubs.opsit.interviews.constants;

import com.ubs.opsit.interviews.enums.ClockProperties;

/**
 * This class contains Constants
 */
public final class BerlinClockConstants
{

	public static final String YYY = ClockProperties.YELLOW.getValue() + "" + ClockProperties.YELLOW.getValue() + ""
			+ ClockProperties.YELLOW.getValue();

	public static final String YYR = ClockProperties.YELLOW.getValue() + "" + ClockProperties.YELLOW.getValue() + ""
			+ ClockProperties.RED.getValue();
	
	public static final String SPLIT_WITH = ":";
	
	public static final String NEW_LINE = "\r\n";
}
