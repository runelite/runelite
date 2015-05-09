package info.sigterm.deob.attributes.code;

import info.sigterm.deob.attributes.Code;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Exceptions
{
	private Code code;
	private List<Exception> exceptions = new ArrayList<Exception>();

	public Exceptions(Code code) throws IOException
	{
		this.code = code;

		DataInputStream is = code.getAttributes().getStream();

		int count = is.readUnsignedShort();

		for (int i = 0; i < count; ++i)
			exceptions.add(new Exception(this));
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(exceptions.size());
		for (Exception e : exceptions)
			e.write(out);
	}

	public Code getCode()
	{
		return code;
	}
	
	public Collection<Exception> getHandlersForPc(int pc)
	{
		ArrayList<Exception> matches = new ArrayList<Exception>();

		for (Exception e : exceptions)
		{
			if (pc >= e.getStartPc() && pc < e.getEndPc())
			{
				/* possible match */
				matches.add(e);
			}
		}
		
		return matches;
	}
}