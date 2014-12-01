package info.sigterm.deob.attributes.code;

import info.sigterm.deob.attributes.Code;

import java.io.DataInputStream;
import java.io.IOException;

public class Exceptions
{
	private Code code;
	private Exception[] exceptions;

	public Exceptions(Code code) throws IOException
	{
		this.code = code;

		DataInputStream is = code.getAttributes().getStream();

		int count = is.readUnsignedShort();
		exceptions = new Exception[count];

		for (int i = 0; i < count; ++i)
			exceptions[i] = new Exception(this);
	}

	public Code getCode()
	{
		return code;
	}
}