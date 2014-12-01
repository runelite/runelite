package info.sigterm.deob;

import java.io.DataInputStream;
import java.io.IOException;

public class Methods
{
	ClassFile classFile;

	private int count;
	private Method[] methods;

	Methods(ClassFile cf) throws IOException
	{
		classFile = cf;

		DataInputStream is = cf.getStream();

		count = is.readUnsignedShort();
		methods = new Method[count];

		for (int i = 0; i < count; ++i)
			methods[i] = new Method(this);
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}

	public void buildInstructionGraph()
	{
		for (Method m : methods)
			m.buildInstructionGraph();
	}
}
