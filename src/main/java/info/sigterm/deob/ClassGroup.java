package info.sigterm.deob;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ClassGroup
{
	private ArrayList<ClassFile> classes = new ArrayList<ClassFile>();

	public ClassGroup()
	{
	}

	public ClassFile addClass(String name, DataInputStream is) throws IOException
	{
		ClassFile cf = new ClassFile(this, is);
		classes.add(cf);
		return cf;
	}

	public ClassFile findClass(String name)
	{
		for (ClassFile c : classes)
			if (c.getName().equals(name))
				return c;
		return null;
	}

	public void buildClassGraph()
	{
		for (ClassFile c : classes)
			c.buildClassGraph();
	}

	public void buildInstructionGraph()
	{
		for (ClassFile c : classes)
			c.buildInstructionGraph();
	}
}
