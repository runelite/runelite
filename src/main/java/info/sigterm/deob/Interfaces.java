package info.sigterm.deob;

import info.sigterm.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Interfaces
{
	private ClassFile classFile;

	private List<Class> interfaces = new ArrayList<Class>();

	Interfaces(ClassFile c) throws IOException
	{
		classFile = c;

		DataInputStream is = c.getStream();

		int count = is.readUnsignedShort();

		for (int i = 0; i < count; ++i)
			interfaces.add(c.getPool().getClass(is.readUnsignedShort()));
	}
	
	public List<ClassFile> getInterfaces()
	{
		List<ClassFile> l = new ArrayList<>();
		for (Class clazz : interfaces)
		{
			ClassFile iface = classFile.getGroup().findClass(clazz.getName());
			if (iface != null)
				l.add(iface);
		}
		return l;
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(interfaces.size());
		for (Class clazz : interfaces)
			out.writeShort(classFile.getPool().make(clazz));
	}
	
	public boolean instanceOf(ClassFile cf)
	{
		for (Class clazz : interfaces)
		{
			ClassFile iface = classFile.getGroup().findClass(clazz.getName());
			if (iface.instanceOf(cf))
				return true;
		}
		return false;
	}
}
