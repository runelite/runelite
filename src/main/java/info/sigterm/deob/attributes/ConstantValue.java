package info.sigterm.deob.attributes;

import info.sigterm.deob.pool.PoolEntry;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantValue extends Attribute
{
	private int constantVlaueIndex;

	public ConstantValue(Attributes attributes) throws IOException
	{
		super(attributes, AttributeType.CONSTANT_VALUE);

		DataInputStream is = attributes.getStream();
		constantVlaueIndex = is.readUnsignedShort();
	}

	public PoolEntry getValue()
	{
		return this.getAttributes().getClassFile().getPool().getEntry(constantVlaueIndex);
	}
}
