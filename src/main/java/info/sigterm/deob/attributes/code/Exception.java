package info.sigterm.deob.attributes.code;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.IOException;

public class Exception
{
	private Exceptions exceptions;

	private int startPc;
	private int endPc;
	private int handlerPc;
	private int catchType;

	public Exception(Exceptions exceptions) throws IOException
	{
		this.exceptions = exceptions;

		DataInputStream is = exceptions.getCode().getAttributes().getStream();

		startPc = is.readUnsignedShort();
		endPc = is.readUnsignedShort();
		handlerPc = is.readUnsignedShort();
		catchType = is.readUnsignedShort();
	}
	
	public Exceptions getExceptions()
	{
		return exceptions;
	}
	
	public int getStartPc()
	{
		return startPc;
	}
	
	public int getEndPc()
	{
		return endPc;
	}
	
	public int getHandlerPc()
	{
		return handlerPc;
	}
}
