package com.ubs.opsit.interviews.transferobject;

import java.io.Serializable;

public final class ClockTo implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3667874515766127961L;

	private Integer hours = null;

	private Integer minutes = null;

	private Integer seconds = null;

	/**
	 * @return the hours
	 */
	public Integer getHours()
	{
		return hours;
	}

	/**
	 * @param hours
	 *            the hours to set
	 */
	public void setHours(Integer hours)
	{
		this.hours = hours;
	}

	/**
	 * @return the minutes
	 */
	public Integer getMinutes()
	{
		return minutes;
	}

	/**
	 * @param minutes
	 *            the minutes to set
	 */
	public void setMinutes(Integer minutes)
	{
		this.minutes = minutes;
	}

	/**
	 * @return the seconds
	 */
	public Integer getSeconds()
	{
		return seconds;
	}

	/**
	 * @param seconds
	 *            the seconds to set
	 */
	public void setSeconds(Integer seconds)
	{
		this.seconds = seconds;
	}

}
