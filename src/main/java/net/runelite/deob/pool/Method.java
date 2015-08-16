package net.runelite.deob.pool;

import net.runelite.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Method extends PoolEntry
{
	private int classIndex, natIndex;
	private Class clazz;
	private NameAndType nat;
	
	public Method(Class clazz, NameAndType nat)
	{
		super(ConstantType.METHODREF);
		
		this.clazz = clazz;
		this.nat = nat;
	}

	public Method(ConstantPool pool) throws IOException
	{
		super(ConstantType.METHODREF);

		DataInputStream is = pool.getClassFile().getStream();

		classIndex = is.readUnsignedShort();
		natIndex = is.readUnsignedShort();
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
		if (!(other instanceof Method))
			return false;
		
		Method m = (Method) other;
		return clazz.equals(m.clazz) && nat.equals(m.nat);
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
