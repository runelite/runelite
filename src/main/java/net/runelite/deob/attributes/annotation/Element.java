package net.runelite.deob.attributes.annotation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.deob.ConstantPool;
import net.runelite.deob.pool.PoolEntry;
import net.runelite.deob.signature.Type;

public class Element
{
	private final Annotation annotation;
	private Type type;
	private PoolEntry value;
	
	public Element(Annotation annotation)
	{
		this.annotation = annotation;
	}

	public Annotation getAnnotation()
	{
		return annotation;
	}

	public Type getType()
	{
		return type;
	}

	public void setType(Type type)
	{
		this.type = type;
	}

	public PoolEntry getValue()
	{
		return value;
	}

	public void setValue(PoolEntry value)
	{
		this.value = value;
	}
	
	public String getString()
	{
		return (String) value.getObject();
	}
	
	public void load(DataInputStream is) throws IOException
	{
		ConstantPool pool = annotation.getAnnotations().getAttributes().getClassFile().getPool();
		
		int typeIndex = is.readShort();
		type = new Type(pool.getUTF8(typeIndex));
		
		byte type = is.readByte();
		
		if (type != 's' && type != 'I' && type != 'J')
			throw new RuntimeException("can't parse annotation element type " + type);
		
		int index = is.readShort(); // pool index to String
		
		value = pool.getEntry(index);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		ConstantPool pool = annotation.getAnnotations().getAttributes().getClassFile().getPool();

		out.writeShort(pool.makeUTF8(type.getFullType()));
		byte type;
		switch (value.getType())
		{
			case UTF8:
				type = 's';
				break;
			case INTEGER:
				type = 'I';
				break;
			case LONG:
				type = 'J';
				break;
			default:
				throw new RuntimeException("can't write annotation type " + value);
		}
		out.write(type);
		out.writeShort(pool.make(value));
	}
}
