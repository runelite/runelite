package info.sigterm.deob.attributes;

import info.sigterm.deob.pool.PoolEntry;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantValue extends Attribute
{
	private int constantValueIndex;

	public ConstantValue(Attributes attributes) throws IOException
	{
		super(attributes, AttributeType.CONSTANT_VALUE);

		DataInputStream is = attributes.getStream();
		constantValueIndex = is.readUnsignedShort();
	}

	public PoolEntry getValue()
	{
		return this.getAttributes().getClassFile().getPool().getEntry(constantValueIndex);
	}

	@Override
	public void writeAttr(DataOutputStream out) throws IOException
	{
		out.writeShort(constantValueIndex);
	}
}
