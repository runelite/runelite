package net.runelite.deob.attributes.annotation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.deob.ConstantPool;
import net.runelite.deob.signature.Type;

public class Element
{
	private final Annotation annotation;
	private Type type;
	private String value;
	
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

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
	
	public void load(DataInputStream is) throws IOException
	{
		ConstantPool pool = annotation.getAnnotations().getAttributes().getClassFile().getPool();
		
		int typeIndex = is.readShort();
		type = new Type(pool.getUTF8(typeIndex));
		
		byte type = is.readByte();
		
		if (type != 's')
			throw new RuntimeException("can't parse non string annotation element");
		
		int index = is.readShort(); // pool index to String
		
		value = pool.getUTF8(index);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		ConstantPool pool = annotation.getAnnotations().getAttributes().getClassFile().getPool();

		out.writeShort(pool.makeUTF8(type.toString()));
		out.write('s');
		out.writeShort(pool.makeUTF8(value));
	}
}
