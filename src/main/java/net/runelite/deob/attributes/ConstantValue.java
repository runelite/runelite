package net.runelite.deob.attributes;

import net.runelite.deob.pool.PoolEntry;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantValue extends Attribute
{
	private PoolEntry value;

	public ConstantValue(Attributes attributes)
	{
		super(attributes, AttributeType.CONSTANT_VALUE);
	}
	
	public ConstantValue(Attributes attributes, PoolEntry value)
	{
		super(attributes, AttributeType.CONSTANT_VALUE);
		
		this.value = value;
	}
	
	@Override
	public void loadAttribute() throws IOException
	{
		DataInputStream is = this.getAttributes().getStream();
		value = this.getAttributes().getClassFile().getPool().getEntry(is.readUnsignedShort());
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
