package net.runelite.deob.attributes;

import net.runelite.deob.ClassFile;
import net.runelite.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exceptions extends Attribute
{
	private List<Class> classes = new ArrayList<>();
	
	public Exceptions(Attributes attributes) throws IOException
	{
		super(attributes, AttributeType.EXCEPTIONS);
		
		DataInputStream is = attributes.getStream();
		
		int count = is.readUnsignedShort();
		for (int i = 0; i < count; ++i)
		{
			Class clazz = attributes.getClassFile().getPool().getClass(is.readUnsignedShort());
			classes.add(clazz);
		}
	}

	@Override
	public void writeAttr(DataOutputStream out) throws IOException
	{
		out.writeShort(classes.size());
		for (Class c : classes)
			out.writeShort(this.getAttributes().getClassFile().getPool().make(c));
	}
	
	public void renameClass(ClassFile cf, String name)
	{
		for (Class c : classes)
		{
			if (c.getName().equals(cf.getName()))
			{
				int idx = classes.indexOf(c);
				classes.remove(idx);
				classes.add(idx, new Class(name));
			}
		}
	}
}
