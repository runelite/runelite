package net.runelite.asm.pool;

import net.runelite.asm.ConstantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Field extends PoolEntry
{
	private int classIndex, natIndex;
	private Class clazz;
	private NameAndType nat;

	public Field(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.FIELDREF);

		classIndex = is.readUnsignedShort();
		natIndex = is.readUnsignedShort();
	}
	
	public Field(Class clazz, NameAndType nat)
	{
		super(ConstantType.FIELDREF);
		
		this.clazz = clazz;
		this.nat = nat;
	}

	@Override
	public Field copy()
	{
		return new Field(clazz.copy(), nat.copy());
	}
	
	@Override
	public void resolve(ConstantPool pool)
	{
		clazz = pool.getClass(classIndex);
		nat = pool.getNameAndType(natIndex);		
	}
	
	@Override
	public void prime(ConstantPool pool)
	{
		classIndex = pool.make(clazz);
		natIndex = pool.make(nat);
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Field))
			return false;
		
		Field f = (Field) other;
		return clazz.equals(f.clazz) && nat.equals(f.nat);
	}
	
	@Override
	public int hashCode()
	{
		return clazz.hashCode() ^ nat.hashCode();
	}

	public Class getClassEntry()
	{
		return clazz;
	}

	public NameAndType getNameAndType()
	{
		return nat;
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(classIndex);
		out.writeShort(natIndex);
	}
}
