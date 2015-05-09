package info.sigterm.deob.attributes.code;

import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Exception
{
	private Exceptions exceptions;

	private int startPc;
	private int endPc;
	private int handlerPc;
	private Class cacheType;

	public Exception(Exceptions exceptions) throws IOException
	{
		this.exceptions = exceptions;

		DataInputStream is = exceptions.getCode().getAttributes().getStream();
		ConstantPool pool = exceptions.getCode().getAttributes().getClassFile().getPool();

		startPc = is.readUnsignedShort();
		endPc = is.readUnsignedShort();
		handlerPc = is.readUnsignedShort();
		cacheType = pool.getClass(is.readUnsignedShort());
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		ConstantPool pool = exceptions.getCode().getAttributes().getClassFile().getPool();
		
		out.writeShort(startPc);
		out.writeShort(endPc);
		out.writeShort(handlerPc);
		out.writeShort(cacheType == null ? 0 : pool.make(cacheType));
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
