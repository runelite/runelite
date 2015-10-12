package net.runelite.deob.attributes.code;

import net.runelite.deob.ClassFile;
import net.runelite.deob.attributes.Code;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exceptions
{
	private Code code;
	private List<Exception> exceptions = new ArrayList<Exception>();

	public Exceptions(Code code)
	{
		this.code = code;
	}
	
	public void load(DataInputStream is) throws IOException
	{
		int count = is.readUnsignedShort();

		for (int i = 0; i < count; ++i)
			exceptions.add(new Exception(this, is));
	}
	
	public void add(Exception e)
	{
		exceptions.add(e);
	}
	
	public void remove(Exception e)
	{
		exceptions.remove(e);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(exceptions.size());
		for (Exception e : exceptions)
		{
			assert e.getExceptions() == this;
			e.write(out);
		}
	}

	public Code getCode()
	{
		return code;
	}
	
	public List<Exception> getExceptions()
	{
		return exceptions;
	}
	
	public void renameClass(ClassFile cf, String name)
	{
		for (Exception e : exceptions)
			e.renameClass(cf, name);
	}
}