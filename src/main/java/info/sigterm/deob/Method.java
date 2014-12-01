package info.sigterm.deob;

import java.io.DataInputStream;
import java.io.IOException;

class Method
{
	private Methods methods;

	private short accessFlags;
	private int nameIndex;
	private int descriptorIndex;
	private Attributes attributes;

	Method(Methods methods) throws IOException
	{
		this.methods = methods;

		DataInputStream is = methods.getClassFile().getStream();

		accessFlags = is.readShort();
		nameIndex = is.readUnsignedShort();
		descriptorIndex = is.readUnsignedShort();
		attributes = new Attributes(this);
	}

	public Methods getMethods()
	{
		return methods;
	}
}
