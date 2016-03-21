package net.runelite.asm.pool;

import net.runelite.asm.ConstantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class InterfaceMethod extends PoolEntry
{
	private int classIndex, natIndex;
	private Class clazz;
	private NameAndType nat;
	
	public InterfaceMethod(Class clazz, NameAndType nat)
	{
		super(ConstantType.INTERFACE_METHOD_REF);
		
		this.clazz = clazz;
		this.nat = nat;
	}

	public InterfaceMethod(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.INTERFACE_METHOD_REF);

		classIndex = is.readUnsignedShort();
		natIndex = is.readUnsignedShort();
	}

	@Override
	public InterfaceMethod copy()
	{
		return new InterfaceMethod(clazz.copy(), nat.copy());
	}

	@Override
	public java.lang.String toString()
	{
		return clazz + "." + nat;
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
		if (!(other instanceof InterfaceMethod))
			return false;
		
		InterfaceMethod i = (InterfaceMethod) other;
		return clazz.equals(i.clazz) && nat.equals(i.nat);
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 23 * hash + Objects.hashCode(this.clazz);
		hash = 23 * hash + Objects.hashCode(this.nat);
		return hash;
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
