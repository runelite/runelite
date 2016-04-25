package net.runelite.asm;

import net.runelite.asm.pool.NameAndType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fields
{
	private ClassFile classFile;

	private List<Field> fields = new ArrayList<>();

	Fields(ClassFile c, DataInputStream is) throws IOException
	{
		classFile = c;

		int count = is.readUnsignedShort();

		for (int i = 0; i < count; ++i)
			fields.add(new Field(this, is));
	}
	
	Fields(ClassFile c)
	{
		classFile = c;
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(fields.size());
		for (Field f : fields)
			f.write(out);
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}
	
	public void addField(Field field)
	{
		fields.add(field);
	}

	public List<Field> getFields()
	{
		return fields;
	}

	public Field findField(NameAndType nat)
	{
		for (Field f : fields)
			if (f.getName().equals(nat.getName()) && f.getType().equals(nat.getDescriptorType()))
				return f;
		return null;
	}
	
	public Field findField(String name)
	{
		for (Field f : fields)
			if (f.getName().equals(name))
				return f;
		return null;
	}
}
