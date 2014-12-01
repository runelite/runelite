package info.sigterm.deob;

import java.io.DataInputStream;
import java.io.IOException;

public class Interfaces
{
	private ClassFile classFile;

	private int count;
	private int interfaces[];

	Interfaces(ClassFile c) throws IOException
	{
		classFile = c;

		DataInputStream is = c.getStream();

		count = is.readUnsignedShort();
		interfaces = new int[count];

		for (int i = 0; i < count; ++i)
			interfaces[i] = is.readUnsignedShort();
	}
}
