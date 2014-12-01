package info.sigterm.deob.attributes;

import info.sigterm.deob.Attributes;
import info.sigterm.deob.attributes.code.Exceptions;

import java.io.DataInputStream;
import java.io.IOException;

public class Code extends Attribute
{
	private int maxStack;
	private int maxLocals;
	private Exceptions exceptions;
	private Attributes attributes;

	public Code(Attributes attributes) throws IOException
	{
		super(attributes, AttributeType.CODE);

		DataInputStream is = attributes.getStream();

		maxStack = is.readUnsignedShort();
		maxLocals = is.readUnsignedShort();

		int codeLen = is.readInt();
		is.skip(codeLen);

		exceptions = new Exceptions(this);
		attributes = new Attributes(this);
	}
}
