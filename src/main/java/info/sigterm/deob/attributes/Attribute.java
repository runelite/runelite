package info.sigterm.deob.attributes;

import info.sigterm.deob.Attributes;

import java.io.DataInputStream;
import java.io.IOException;

public class Attribute
{
	private Attributes attributes;
	private AttributeType type;
	private int length;

	Attribute(Attributes attr, AttributeType type) throws IOException
	{
		this.attributes = attr;
		this.type = type;

		DataInputStream is = attr.getStream();
		this.length = is.readInt();
	}

	public Attributes getAttributes()
	{
		return attributes;
	}

	public int getLength()
	{
		return length;
	}
}
