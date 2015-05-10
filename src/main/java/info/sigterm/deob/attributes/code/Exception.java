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
	private Class catchType;

	public Exception(Exceptions exceptions) throws IOException
	{
		this.exceptions = exceptions;

		DataInputStream is = exceptions.getCode().getAttributes().getStream();
		ConstantPool pool = exceptions.getCode().getAttributes().getClassFile().getPool();

		startPc = is.readUnsignedShort();
		endPc = is.readUnsignedShort();
		handlerPc = is.readUnsignedShort();
		catchType = pool.getClass(is.readUnsignedShort());
		
		Instruction ins = exceptions.getCode().getInstructions().findInstruction(handlerPc);
		ins.exce.add(this);
	}
	
	protected void remove()
	{
		Instruction ins = exceptions.getCode().getInstructions().findInstruction(handlerPc);
		ins.exce.remove(this);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		ConstantPool pool = exceptions.getCode().getAttributes().getClassFile().getPool();
		
		out.writeShort(startPc);
		out.writeShort(endPc);
		out.writeShort(handlerPc);
		out.writeShort(catchType == null ? 0 : pool.make(catchType));
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
	
	public Class getCatchType()
	{
		return catchType;
	}
}
