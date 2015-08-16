package net.runelite.deob;

import net.runelite.deob.pool.NameAndType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fields
{
	private ClassFile classFile;

	private List<Field> fields = new ArrayList<>();

	Fields(ClassFile c) throws IOException
	{
		classFile = c;

		DataInputStream is = c.getStream();

		int count = is.readUnsignedShort();

		for (int i = 0; i < count; ++i)
			fields.add(new Field(this));
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
}
