package net.runelite.deob.attributes;

import net.runelite.deob.pool.PoolEntry;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

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
	public void loadAttribute(DataInputStream is) throws IOException
	{
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

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 79 * hash + Objects.hashCode(this.value);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final ConstantValue other = (ConstantValue) obj;
		if (!Objects.equals(this.value, other.value))
		{
			return false;
		}
		return true;
	}
}
