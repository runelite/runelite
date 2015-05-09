package info.sigterm.deob;

import info.sigterm.deob.pool.ConstantType;
import info.sigterm.deob.pool.InterfaceMethod;
import info.sigterm.deob.pool.NameAndType;
import info.sigterm.deob.pool.PoolEntry;
import info.sigterm.deob.pool.UTF8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;

public class ConstantPool
{
	private ClassFile classFile;

	private List<PoolEntry> entries = new ArrayList<PoolEntry>();
	
	ConstantPool(ClassFile c)
	{
		classFile = c;
	}

	ConstantPool(ClassFile c, DataInputStream is) throws IOException
	{
		this(c);

		int count = is.readUnsignedShort();

		for (int i = 1; i < count; ++i)
		{
			byte typeCode = is.readByte();

			ConstantType type = ConstantType.findFromType(typeCode);

			try
			{
				Constructor<? extends PoolEntry> con = type.getPoolClass().getConstructor(new Class[] { ConstantPool.class });
				PoolEntry entry = con.newInstance(this);
				entry.id = i;

				entries.add(entry);
				i += entry.getSlots() - 1;
			}
			catch (Exception e)
			{
				throw new IOException(e);
			}
		}
		
		for (PoolEntry entry : entries)
			entry.resolve();
	}
	
	public void reset()
	{
		for (PoolEntry entry : entries)
		{
			entry.id = 0;
		}
		
		entries.clear();
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		/* this grows as it is iterated */
		for (int i = 0; i < entries.size(); ++i)
		{
			PoolEntry entry = entries.get(i);
			entry.prime();
		}
		
		int size = 0;
		for (PoolEntry entry : entries)
			size += entry.getSlots();
		
		out.writeShort(size + 1);
		int i = 1;
		for (PoolEntry entry : entries)
		{
			assert i == entry.id;
			i += entry.getSlots();
			
			out.writeByte(entry.getType().getType());
			entry.write(out);
		}
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}

	public PoolEntry getEntry(int index)
	{
		for (PoolEntry entry : entries)
			if (entry.id == index)
				return entry;
		return null;
	}
	
	public String getUTF8(int index)
	{
		PoolEntry entry = getEntry(index);
		UTF8 u = (UTF8) entry;
		return u.getValue();
	}
	
	public info.sigterm.deob.pool.Class getClass(int index)
	{
		return (info.sigterm.deob.pool.Class) getEntry(index);
	}
	
	public info.sigterm.deob.pool.Field getField(int index)
	{
		return (info.sigterm.deob.pool.Field) getEntry(index);
	}
	
	public InterfaceMethod getInterfaceMethod(int index)
	{
		return (InterfaceMethod) getEntry(index);
	}
	
	public info.sigterm.deob.pool.Method getMethod(int index)
	{
		return (info.sigterm.deob.pool.Method) getEntry(index);
	}
	
	public NameAndType getNameAndType(int index)
	{
		return (NameAndType) getEntry(index);
	}
	
	public Object get(int index)
	{
		PoolEntry entry = getEntry(index);
		return entry.getObject();
	}
	
	public int make(PoolEntry entry)
	{
		int i = 1;
		
		for (PoolEntry e : entries)
		{
			if (e.equals(entry))
				return i;
			
			i += e.getSlots();
		}
		
		entries.add(entry);
		entry.id = i;
		entry.pool = this;
		return i;
	}
	
	public int makeUTF8(String str)
	{
		return make(new UTF8(str));
	}
	
	public int make(Object object)
	{
		if (object instanceof String)
			return make(new info.sigterm.deob.pool.String(this, (String) object));
		
		if (object instanceof Integer)
			return make(new info.sigterm.deob.pool.Integer(this, (int) object));
		
		if (object instanceof Float)
			return make(new info.sigterm.deob.pool.Float(this, (float) object));
		
		if (object instanceof Long)
			return make(new info.sigterm.deob.pool.Long(this, (long) object));
		
		if (object instanceof Double)
			return make(new info.sigterm.deob.pool.Double(this, (double) object));
		
		System.err.println("Constant pool make with unknown object " + object + " type " + object.getClass());
		
		return 0;
	}
}
