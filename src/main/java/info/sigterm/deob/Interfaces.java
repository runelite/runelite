package info.sigterm.deob;

import info.sigterm.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(count);
		for (int i : interfaces)
			out.writeShort(i);
	}
	
	public boolean instanceOf(ClassFile cf)
	{
		for (int i : interfaces)
		{
			Class clazz = (Class) classFile.getPool().getEntry(i);
			ClassFile iface = classFile.getGroup().findClass(clazz.getName());
			if (iface.instanceOf(cf))
				return true;
		}
		return false;
	}
}
