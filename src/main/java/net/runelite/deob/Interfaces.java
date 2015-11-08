package net.runelite.deob;

import net.runelite.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Interfaces
{
	private ClassFile classFile;

	private List<Class> interfaces = new ArrayList<Class>();

	Interfaces(ClassFile c, DataInputStream is) throws IOException
	{
		classFile = c;

		int count = is.readUnsignedShort();

		for (int i = 0; i < count; ++i)
			interfaces.add(c.getPool().getClass(is.readUnsignedShort()));
	}
	
	Interfaces(ClassFile c)
	{
		classFile = c;
	}
	
	public List<Class> getInterfaces()
	{
		return interfaces;
	}
	
	public void setInterfaces(List<Class> interfaces)
	{
		this.interfaces = interfaces;
	}
	
	public List<ClassFile> getMyInterfaces()
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
	
	public List<Class> getNonMyInterfaces()
	{
		return interfaces.stream().filter(clazz -> classFile.getGroup().findClass(clazz.getName()) == null).collect(Collectors.toList());
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
