package info.sigterm.deob;

import info.sigterm.deob.pool.NameAndType;

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
	
	public Method findMethod(NameAndType nat)
	{
		for (Method m : methods)
			if (m.getName().equals(nat.getName()) && m.getDescriptor().equals(nat.getDescriptor()))
				return m;
		return null;
	}
	
	public Method findMethod(String name)
	{
		for (Method m : methods)
			if (m.getName().equals(name))
				return m;
		return null;
	}

	public void buildInstructionGraph()
	{
		for (Method m : methods)
			m.buildInstructionGraph();
	}
}
