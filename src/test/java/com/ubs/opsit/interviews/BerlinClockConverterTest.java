package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ubs.opsit.interviews.exceptions.ApplicationException;
import com.ubs.opsit.interviews.impl.BerlinClockConverter;

public class BerlinClockConverterTest
{
	private static BerlinClockConverter converter = null;

	@BeforeClass
	public	 static void setUp()
	{
		converter = new BerlinClockConverter();
	}

	@Test
	public void testCreateObject()
	{
		Assert.assertTrue(converter != null);
	}

	@Test(expected = ApplicationException.class)
	public void testNULL()
	{
		converter.convertTime(null);
	}

	@Test(expected = ApplicationException.class)
	public void testEMPTY()
	{
		converter.convertTime("");
	}

	@Test(expected = ApplicationException.class)
	public void testString()
	{
		converter.convertTime("JOYASH");
	}

	@Test(expected = ApplicationException.class)
	public void testString2()
	{
		converter.convertTime("00:00:");
	}

	@Test(expected = ApplicationException.class)
	public void testException1()
	{
		converter.convertTime("25:00:00");
	}

	@Test(expected = ApplicationException.class)
	public void testException2()
	{
		converter.convertTime("-1:00:00");
	}

	@Test(expected = ApplicationException.class)
	public void testException3()
	{

		converter.convertTime("01:MM:00");
	}

	@Test(expected = ApplicationException.class)
	public void testException4()
	{
		converter.convertTime("01:60:00");
	}

	@Test(expected = ApplicationException.class)
	public void testException5()
	{
		converter.convertTime("01:-01:00");
	}

	@Test(expected = ApplicationException.class)
	public void testException6()
	{
		converter.convertTime("01:01:SS");
	}

	@Test(expected = ApplicationException.class)
	public void testException7()
	{
		converter.convertTime("01:01:60");
	}

	@Test(expected = ApplicationException.class)
	public void testException8()
	{
		converter.convertTime("01:01:-1");
	}

	@Test
	public void testScenario1()
	{
		final String expected = "Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO";
		Assert.assertEquals("OUTPUT did not Match", expected, converter.convertTime("00:00:00"));
	}

	@Test
	public void testScenario2()
	{
		final String expected = "O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO";
		Assert.assertEquals("OUTPUT did not Match", expected, converter.convertTime("13:17:01"));
	}

	@Test
	public void testScenario3()
	{
		final String expected = "O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY";
		Assert.assertEquals("OUTPUT did not Match", expected, converter.convertTime("23:59:59"));
	}

	@Test
	public void testScenario4()
	{
		final String expected = "Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO";
		Assert.assertEquals("OUTPUT did not Match", expected, converter.convertTime("24:00:00"));
	}

}
