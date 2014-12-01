package info.sigterm.deob;

import info.sigterm.deob.attributes.AttributeType;
import info.sigterm.deob.attributes.Attributes;
import info.sigterm.deob.attributes.Code;

import java.io.DataInputStream;
import java.io.IOException;

public class Method
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

	public Code getCode()
	{
		return (Code) attributes.findType(AttributeType.CODE);
	}

	public void buildInstructionGraph()
	{
		Code code = getCode();

		if (code != null)
			code.buildInstructionGraph();
	}
}
