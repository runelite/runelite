package net.runelite.deob;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.runelite.deob.attributes.Code;

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
	
	public void addClass(ClassFile cf)
	{
		classes.add(cf);
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
	
	public void initialize()
	{
		sort();
		buildClassGraph();
		lookup();
	}
	
	private int classNum(ClassFile cf)
	{
		if (cf.getName().startsWith("class"))
			return Integer.parseInt(cf.getName().substring(5));
		
		return -1;
	}
	
	// order of classes affects class graph (eg order of children classes) which affects comparing two classgroups
	private void sort()
	{
		// only sort renamed jars
		for (ClassFile c : classes)
			if (c.getName().startsWith("class") == false && !c.getName().equals("client"))
				return;
		
		Collections.sort(classes, (c1, c2) -> {
			int n1 = classNum(c1), n2 = classNum(c2);
			return Integer.compare(n1, n2);
		});
	}

	public void buildClassGraph()
	{
		for (ClassFile c : classes)
			c.clearClassGraph();
		
		for (ClassFile c : classes)
			c.buildClassGraph();
	}
	
	public void lookup()
	{
		for (ClassFile cf : this.getClasses())
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				
				if (code == null)
					continue;
				
				code.getInstructions().lookup();
			}
		
	}
}
