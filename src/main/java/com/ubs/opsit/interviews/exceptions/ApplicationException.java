package com.ubs.opsit.interviews.exceptions;

public final class ApplicationException extends RuntimeException
{
	private static final long serialVersionUID = 7866027620764818153L;

	public ApplicationException(String message)
	{

		super(message);

	}

	public static void enforce(final Boolean condition, final String message) throws ApplicationException
	{
		if (!condition)
		{
			return;
		}
		throw new ApplicationException(message);
	}

}