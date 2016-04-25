package net.runelite.asm.attributes;

import net.runelite.asm.ClassFile;
import net.runelite.asm.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exceptions extends Attribute
{
	private List<Class> classes = new ArrayList<>();
	
	public Exceptions(Attributes attributes)
	{
		super(attributes, AttributeType.EXCEPTIONS);
	}
	
	@Override
	public void loadAttribute(DataInputStream is) throws IOException
	{
		int count = is.readUnsignedShort();
		for (int i = 0; i < count; ++i)
		{
			Class clazz = this.getAttributes().getClassFile().getPool().getClass(is.readUnsignedShort());
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
