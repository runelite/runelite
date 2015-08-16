package net.runelite.deob.attributes;

import net.runelite.deob.pool.PoolEntry;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantValue extends Attribute
{
	private PoolEntry value;

	public ConstantValue(Attributes attributes) throws IOException
	{
		super(attributes, AttributeType.CONSTANT_VALUE);

		DataInputStream is = attributes.getStream();
		value = this.getAttributes().getClassFile().getPool().getEntry(is.readUnsignedShort());
	}
	
	public ConstantValue(Attributes attributes, PoolEntry value)
	{
		super(attributes, AttributeType.CONSTANT_VALUE, -1);
		
		this.value = value;
	}

	public PoolEntry getValue()
	{
		return value;
	}

	@Override
	public void writeAttr(DataOutputStream out) throws IOException
	{
		out.writeShort(this.getAttributes().getClassFile().getPool().make(value));
	}
}
