package info.sigterm.deob;

import java.io.DataInputStream;
import java.io.IOException;

public class Fields
{
	private ClassFile classFile;

	private int count;
	private Field[] fields;

	Fields(ClassFile c) throws IOException
	{
		classFile = c;

		DataInputStream is = c.getStream();

		count = is.readUnsignedShort();
		fields = new Field[count];

		for (int i = 0; i < count; ++i)
			fields[i] = new Field(this);
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}
}
