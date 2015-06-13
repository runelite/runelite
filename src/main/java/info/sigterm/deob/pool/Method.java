package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Method extends PoolEntry
{
	private int classIndex, natIndex;
	private Class clazz;
	private NameAndType nat;
	
	public Method(ConstantPool pool, Class clazz, NameAndType nat)
	{
		super(pool, ConstantType.METHODREF);
		
		this.clazz = clazz;
		this.nat = nat;
	}

	public Method(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.METHODREF);

		DataInputStream is = pool.getClassFile().getStream();

		classIndex = is.readUnsignedShort();
		natIndex = is.readUnsignedShort();
	}
	
	@Override
	public void resolve()
	{
		clazz = this.getPool().getClass(classIndex);
		nat = this.getPool().getNameAndType(natIndex);
	}
	
	@Override
	public void prime()
	{
		classIndex = this.getPool().make(clazz);
		natIndex = this.getPool().make(nat);		
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
