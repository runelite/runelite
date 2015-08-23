package net.runelite.deob;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClassGroup
{
	private List<ClassFile> classes = new ArrayList<>();

	public ClassGroup()
	{
	}

	public ClassFile addClass(String name, DataInputStream is) throws IOException
	{
		ClassFile cf = new ClassFile(this, is);
		classes.add(cf);
		return cf;
	}
	
	public void removeClass(ClassFile cf)
	{
		classes.remove(cf);
	}
	
	public List<ClassFile> getClasses()
	{
		return classes;
	}

	public ClassFile findClass(String name)
	{
		// XXX handle arrays?
		for (ClassFile c : classes)
			if (c.getName().equals(name))
				return c;
		return null;
	}

	public void buildClassGraph()
	{
		for (ClassFile c : classes)
			c.clearClassGraph();
		
		for (ClassFile c : classes)
			c.buildClassGraph();
	}
}
