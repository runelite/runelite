package net.runelite.deob.attributes.code;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ConstantPool;
import net.runelite.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Exception
{
	private Exceptions exceptions;

	private Instruction start, end, handler;
	private Class catchType;

	public Exception(Exceptions exceptions) throws IOException
	{
		this.exceptions = exceptions;

		DataInputStream is = exceptions.getCode().getAttributes().getStream();
		ConstantPool pool = exceptions.getCode().getAttributes().getClassFile().getPool();

		int startPc = is.readUnsignedShort();
		int endPc = is.readUnsignedShort();
		int handlerPc = is.readUnsignedShort();
		catchType = pool.getClass(is.readUnsignedShort());
		
		Instructions instructions = exceptions.getCode().getInstructions();
		start = instructions.findInstruction(startPc);
		end = instructions.findInstruction(endPc);
		handler = instructions.findInstruction(handlerPc);
		
		assert start != null;
		assert end != null;
		assert handler != null;
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		ConstantPool pool = exceptions.getCode().getAttributes().getClassFile().getPool();
		
		assert start.getInstructions() == exceptions.getCode().getInstructions();
		assert end.getInstructions() == exceptions.getCode().getInstructions();
		assert handler.getInstructions() == exceptions.getCode().getInstructions();
		
		assert start.getInstructions().getInstructions().contains(start);
		assert end.getInstructions().getInstructions().contains(end);
		assert handler.getInstructions().getInstructions().contains(handler);
		
		out.writeShort(start.getPc());
		out.writeShort(end.getPc());
		out.writeShort(handler.getPc());
		out.writeShort(catchType == null ? 0 : pool.make(catchType));
	}
	
	public Exceptions getExceptions()
	{
		return exceptions;
	}
	
	public void setExceptions(Exceptions exceptions)
	{
		this.exceptions = exceptions;
	}
	
	public Instruction getStart()
	{
		return start;
	}
	
	public void setStart(Instruction ins)
	{
		start = ins;
	}
	
	public Instruction getEnd()
	{
		return end;
	}
	
	public Instruction getHandler()
	{
		return handler;
	}
	
	public void replace(Instruction oldi, Instruction newi)
	{
		if (start == oldi)
			start = newi;
		
		if (end == oldi)
			end = newi;
		
		if (handler == oldi)
			handler = newi;
	}
	
	public Class getCatchType()
	{
		return catchType;
	}
	
	public void renameClass(ClassFile cf, String name)
	{
		if (catchType != null && cf.getName().equals(catchType.getName()))
			catchType = new Class(name);
	}
}
