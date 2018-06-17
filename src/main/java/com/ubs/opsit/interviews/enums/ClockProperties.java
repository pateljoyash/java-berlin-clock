package com.ubs.opsit.interviews.enums;

public enum ClockProperties
{
	YELLOW('Y'), RED('R'), OFF('O');

	private final char color;

	private ClockProperties(char color)
	{
		this.color = color;
	}

	public char getValue()
	{
		return this.color;
	}
}
